package colony

import org.grails.datastore.mapping.query.api.Criteria

class UiController
{
//	def springSecurityService
//	def colonyService
//	
//	Map<String, Colony> getMembersColonies()
//	{
//		LinkedHashMap<String, Colony> colonies = new LinkedHashMap<String, Colony>() 
//		Member member = springSecurityService.currentUser
//		
//		if (member != null)
//		{
//			def membersColonies = Colony.withCriteria {
//				members {
//					eq('id', member.id)
//				}
//			}
//	
//			if (membersColonies.size() == 0)
//			{
//				// new user, add them to the default colony "Colony"
//				Colony colony = Colony.findWhere([name: "Colony"])
//				
//				if (colony == null)
//				{
//					// create the default Colony
//					colony = colonyService.createColony("Colony")
//				}
//				
//				colonyService.addMember(colony, member);
//				colonies.put(colony.id, colony)
//			}
//			else
//			{
//				membersColonies.each 
//				{ Colony colony ->
//					colonies.put(colony.id, colony)
//				}
//				
//			}
//		}
//		
//		return colonies
//	}
//	
//	def index()
//	{
//		return colony()
//	}
//	
//	def newPost()
//	{
//		def model = [:]
//		model.member = springSecurityService.currentUser
//		model.postInstance = new UIPost()
//		
//		render (view: "newPost", model: model)
//	}
//	
//	def savePost()
//	{
//		colonyService.createPost(params.title, params.content, params.colonies.id)
//		
//		redirect(action: "index")
//	}
//	
//	def deletePost()
//	{
//		colonyService.deletePost(params.id)
//		
//		redirect(action: "index")
//	}
//	
//	def unlinkPost()
//	{
//		colonyService.unlinkPost(params.colony, params.post)
//		
//		redirect(action: "index")
//	}
//	
//	def updatePost()
//	{
//		colonyService.updatePost(params.id, params.title, params.content)
//		
//		redirect(action: "index")
//	}
//	
//	def editPost()
//	{
//		def model = [:]
//		UIPost uiPost = new UIPost()
//		Post p = Post.findById(params.id)
//		model.member = springSecurityService.currentUser
//		model.postInstance = uiPost
//		
//		VersionedPost vp = p.getCurrent()
//		uiPost.id = p.id
//		uiPost.title = vp.getTitle()
//		uiPost.content = vp.getContent()
//		uiPost.colonies = new LinkedList<Colony>()
//		
//		Entry.executeQuery("FROM Entry WHERE post_id=:post_id", [post_id: params.id]).each 
//		{ Entry e ->
//			uiPost.colonies.add(e.colony)
//		}
//		 
//		render (view: "editPost", model: model)
//	}
//	
//	def colony()
//	{
//		def model = [:]
//		model.member = springSecurityService.currentUser 
//		model.colonies = getMembersColonies()
//		
//		if (params.colony)
//		{
//			model.colonies.each
//			{ String id, Colony colony ->
//				if (colony.name.equalsIgnoreCase(params.colony))
//				{
//					model.colony = colony
//				}
//			}
//
//		}
//		else if (params.id)
//		{
//			model.colonies.each 
//			{ String id, Colony colony ->
//				if (colony.id == params.id)
//				{
//					model.colony = colony
//				}
//			}
//		}
//		
//		model.posts = new LinkedHashMap<String, Post>()
//			
//		Entry.executeQuery("SELECT id FROM Entry ORDER BY created DESC").each
//		{ entryId ->
//			Entry entry = Entry.findById(entryId)
//			Colony colony = Colony.findById(entry.colony.id)
//			
//			if (colony.open || (colony = model.colonies[entry.colony.id]))
//			{
//				if (!model.posts[entry.post.id])
//				{
//					model.posts[entry.post.id] = entry.post
//				}
//				
//				model.posts[entry.post.id].colonies.put(colony.name, colony)
//			}
//		}
//		
//		model.posts = model.posts.findAll 
//		{ String key, Post post ->
//			VersionedPost version = post.current
//
//			if (!model.colony || post.colonies.get(model.colony.name))
//			{			
//				while (version)
//				{
//					post.members.put(version.member, version.member)
//					version = version.previous
//				}
//				
//				post
//			} 
//		}.collect { k, v -> v }
//		
//		render (view: "index", model: model)
//	}
}
