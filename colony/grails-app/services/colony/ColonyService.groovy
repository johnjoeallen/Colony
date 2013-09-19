package colony

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class ColonyService 
{
	def springSecurityService
	
	/**
	 * 
	 * @param name
	 * @return
	 */
    def createColony(String name)
	{
		Colony colony = new Colony([name: name])
		colony.save()
		
		return colony
    }

	/**
	 * 	
	 * @param p
	 * @param colonyId
	 * @return
	 */
	def addPostToColony(Post p, String colonyId)
	{
		Colony colony = Colony.findWhere([id: colonyId])
		Entry entry = new Entry()
		entry.post = p
		entry.colony = colony
		entry.save()
		colony.addToEntries(entry)
		colony.save()
	}
	
	/**
	 * 
	 * @param title
	 * @param content
	 * @param colonyId
	 * @return
	 */
	def createPost(String title, String content, String colonyId)
	{
		VersionedPost vpost = new VersionedPost()
		vpost.title = title
		vpost.content = content
		vpost.member =  springSecurityService.currentUser
		vpost.save()
		
		Post post = new Post()
		post.type = "blog"
		post.current = vpost
		post.member =  springSecurityService.currentUser
		post.save()
		
		println "colonyId=${colonyId}"
		addPostToColony(post, colonyId)
	}
	
	/**
	 * 
	 * @param title
	 * @param content
	 * @param colonyIds
	 * @return
	 */
	def createPost(String title, String content, String[] colonyIds)
	{
		VersionedPost vpost = new VersionedPost()
		vpost.title = title
		vpost.content = content
		vpost.member =  springSecurityService.currentUser
		vpost.save()
		
		Post post = new Post()
		post.type = "blog"
		post.current = vpost
		post.member =  springSecurityService.currentUser
		post.save()
		
		println "colonyIds=${colonyIds}"
		
		colonyIds.each
		{ it ->
			println "it=${it}"
			addPostToColony(post, it)
		}
	}
	
	/**
	 * Deletes a post and all versions, and removes from all colonies
	 * @param id
	 * @return
	 */
	def deletePost(String id)
	{
		Post p = Post.findById(id)
		
		if (p)
		{
			// delete entries from colonies
			Entry.executeQuery("FROM Entry WHERE post_id=:post_id", [post_id: p.id]).each
			{ Entry e ->
				e.delete()
			}

			p.delete()
						
			VersionedPost vp = p.current
			
			while (vp)
			{
				VersionedPost previous = vp.previous
				vp.delete()
				vp = previous
			}
		}
	}

	
	/**
	 * 
	 * @param colonyId
	 * @param postId
	 * @return
	 */
	def unlinkPost(String colonyId, String postId)
	{
		int count = 0
		Entry.executeQuery("FROM Entry WHERE colony_id=:colony_id AND post_id=:post_id", [post_id: postId, colony_id: colonyId]).each
		{ Entry e ->
			e.delete()
			count++
		}
		
		if (count == 1)
		{
			// this was the last viewable instance of this post, delete it?
			deletePost(postId)
		}
	}
	
	def updatePost(String id, String title, String content)
	{
		Post p = Post.findById(id)
		
		if (p)
		{
			VersionedPost vpost = new VersionedPost()
			vpost.title = title
			vpost.content = content
			vpost.member =  springSecurityService.currentUser
			vpost.previous = p.current
			vpost.save()
			
			p.current = vpost
			p.save()

			Entry.executeQuery("FROM Entry WHERE post_id=:post_id", [post_id: id]).each
			{ Entry e ->
				e.created = new Date()
			}
		}
	}

	/**
	 * 
	 * @param c
	 * @param m
	 * @return
	 */
	def addMember(Colony c, Member m)
	{
		c.addToMembers(m)
		c.save()
	}
}
