package colony

class AuthenticatedFilters {
	def springSecurityService
	
    def filters = {
        all(controller:'*', action:'*') {
            before = {
            }
			
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
