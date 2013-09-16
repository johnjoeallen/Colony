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

		model.colonies = Colony.withCriteria {
			members {
				eq('id', member.id)
			}
		}

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
		
		if (model.colony == null)
		{
			model.colony = model.colonies.first()
		}
		
		render (view: "index", model: model)
	}
}
