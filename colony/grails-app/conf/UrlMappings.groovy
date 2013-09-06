class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller:"ui")
		"/admin"(view: "/index")
		"500"(view:'/error')
	}
}