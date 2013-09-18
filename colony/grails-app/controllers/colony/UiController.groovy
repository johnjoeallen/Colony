package colony

import org.grails.datastore.mapping.query.api.Criteria

class UiController
{
	def springSecurityService
	def colonyService
	
	Map<String, Colony> getMembersColonies()
	{
		LinkedHashMap<String, Colony> colonies = new LinkedHashMap<String, Colony>() 
		Member member = springSecurityService.currentUser
		
		if (member != null)
		{
			def membersColonies = Colony.withCriteria {
				members {
					eq('id', member.id)
				}
			}
	
			if (membersColonies.size() == 0)
			{
				// new user, add them to the default colony "Colony"
				Colony colony = Colony.findWhere([name: "Colony"])
				
				if (colony == null)
				{
					// create the default Colony
					colony = colonyService.createColony("Colony")
				}
				
				colonyService.addMember(colony, member);
				colonies.put(colony.id, colony)
			}
			else
			{
				membersColonies.each 
				{ Colony colony ->
					colonies.put(colony.id, colony)
				}
				
			}
		}
		
		return colonies
	}
	
	def index()
	{
		return colony()
	}
	
	def newPost()
	{
		def model = [:]
		model.member = springSecurityService.currentUser
		 
		render (view: "newPost", model: model)
	}
	
	def savePost()
	{
		params.each { k, v ->
			println "${k} = ${v}"
		}
		
		colonyService.createPost(params.title, params.content, params.colonies.id)
		
		return colony()
	}
	
	def colony()
	{
		def model = [:]
		model.member = springSecurityService.currentUser 
		model.colonies = getMembersColonies()
		
		if (model.member != null)
		{
			if (params.colony)
			{
				model.colonies.each
				{ String id, Colony colony ->
					if (colony.name.equalsIgnoreCase(params.colony))
					{
						model.colony = colony
					}
				}
	
			}
			else if (params.id)
			{
				model.colonies.each 
				{ String id, Colony colony ->
					if (colony.id == params.id)
					{
						model.colony = colony
					}
				}
			}
			
			model.posts = new LinkedHashMap<String, Post>()
				
			Entry.executeQuery("SELECT id FROM Entry ORDER BY created DESC").each
			{ entryId ->
				Entry entry = Entry.findById(entryId)
				println entry
				Colony colony = model.colonies[entry.colony.id]
				if (colony)
				{
					if (!model.posts[entry.post.id])
					{
						model.posts[entry.post.id] = entry.post
					}
					
					model.posts[entry.post.id].colonies.put(colony.name, colony)
				}
			}
			
			model.posts = model.posts.findAll 
			{ String key, Post post ->
				VersionedPost version = post.current
	
				if (!model.colony || post.colonies.get(model.colony.name))
				{			
					while (version)
					{
						post.members.put(version.member.fullname, version.member)
						version = version.previous
					}
					
					post
				} 
			}.collect { k, v -> v }
		}
		
		render (view: "index", model: model)
	}
}
