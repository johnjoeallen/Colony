class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller:"ui")
		"/colony/newPost"(controller:"ui", action="newPost")
		"/colony/ui/savePost"(controller:"ui", action="savePost")
		"/colony/unlinkPost/$colony/$post"(controller:"ui", action="unlinkPost")
		"/colony/editPost/$id"(controller:"ui", action="editPost")
		"/colony/$colony"(controller:"ui")
		"/colony/@$user"(controller:"ui")
		"/admin"(view: "/index")
		"500"(view:'/error')
	}
}
