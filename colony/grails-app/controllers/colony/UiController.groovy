package colony

import org.grails.datastore.mapping.query.api.Criteria

class UiController
{
	def springSecurityService
	def colonyService
	
	List<Colony> getMembersColonies()
	{
		List<Colony> colonies
		Member member = springSecurityService.currentUser
		
		if (member != null)
		{
			colonies = Colony.withCriteria {
				members {
					eq('id', member.id)
				}
			}
	
			if (colonies.size() == 0)
			{
				// new user, ass them to the default colony "Colony"
				Colony colony = Colony.findWhere([name: "Colony"])
				
				if (colony == null)
				{
					// create the default Colony
					colony = colonyService.createColony("Colony")
				}
				
				colonyService.addMember(colony, member);
				colonies.add(colony)
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
				{ Colony colony ->
					if (colony.name.equalsIgnoreCase(params.colony))
					{
						model.colony = colony
					}
				}
	
			}
			else if (params.id)
			{
				model.colonies.each 
				{ Colony colony ->
					if (colony.id == params.id)
					{
						model.colony = colony
					}
				}
			}
			
			model.posts = [:]
				
			model.colonies.each
			{ Colony colony ->
				colony.entries.each
				{ Entry entry ->
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
