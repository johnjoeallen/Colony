package colony

class UiController {

    def index()
	{
		def m = [:]
		m.posts = Post.getAll()
		render (view: "index", model: m)
	}
}
