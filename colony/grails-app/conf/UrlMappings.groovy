class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller:"root")
		"/admin"(view: "/index")
		"500"(view:'/error')
	}
}
