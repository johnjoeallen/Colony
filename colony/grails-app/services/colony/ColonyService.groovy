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
