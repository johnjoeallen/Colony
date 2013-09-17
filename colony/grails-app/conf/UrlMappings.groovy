class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller:"ui")
		"/newPost"(controller:"ui", action="newPost")
		"/ui/savePost"(controller:"ui", action="savePost")
		"/$colony"(controller:"ui")
		"/@$user"(controller:"ui")
		"/admin"(view: "/index")
		"500"(view:'/error')
	}
}
