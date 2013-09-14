package colony

import org.grails.datastore.mapping.query.api.Criteria

class UiController
{
	def index()
	{
		return colony()
	}
	
	def colony()
	{
		def model = [:]
		Member member = Member.getAll().first()
		List<Colony> colonies = null

		//		colonies = Colony.findAllByMembersAndId()
		//		colonies = c.get {
		//		   members {
		//			  idEq(member.id)
		//		   }
		//		}

		model.colonies = Colony.withCriteria {
			members {
				eq('id', member.id)
			}
		}

		if (params.id)
		{
			Long colonyId = params.id as Long
			model.colonies.each 
			{ Colony colony ->
				if (colony.id == colonyId)
				{
					println "${colony.id} -- ${colonyId}"
					model.colony = colony
				}
			}
		}
		
		if (model.colony == null)
		{
			model.colony = model.colonies.first()
		}
		
		render (view: "index", model: model)
	}
}
