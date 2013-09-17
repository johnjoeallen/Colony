package colony

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class ColonyService 
{
	def springSecurityService
	
    def createColony(String name)
	{
		Colony colony = new Colony([name: name])
		colony.save()
		
		return colony
    }
	
	def createPost(String title, String content, GrailsParameterMap colonyMap)
	{
		VersionedPost vpost = new VersionedPost()
		vpost.title = title
		vpost.content = content
		vpost.member =  springSecurityService.currentUser
		vpost.save()
		
		Post post = new Post()
		post.type = "blog"
		post.current = vpost
		post.member =  springSecurityService.currentUser
		post.save()
		
		colonyMap.name.each 
		{
			Entry entry = new Entry()
			entry.post = post
			entry.save()
			
			Colony colony = Colony.findWhere([id: it])
			colony.addToEntries(entry)
			colony.save()
		}
	}
	
	def addMember(Colony c, Member m)
	{
		c.addToMembers(m)
		c.save()
	}
}
