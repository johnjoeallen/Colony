package colony

class AuthenticatedFilters {
	def springSecurityService
	
    def filters = {
        all(controller:'*', action:'*') {
            before = {
				Member member = springSecurityService.currentUser
				
				if (member == null)
				{
					redirect(url: "/j_spring_twitter_security_check")
					return false
				}
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
