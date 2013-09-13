package colony

class UiController {

    def index()
	{
		def m = [:]
		Colony colony = Colony.findByName("MasterCard Labs")
		m.colony = colony
		render (view: "index", model: m)
	}
}
