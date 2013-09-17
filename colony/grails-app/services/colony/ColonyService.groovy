package colony

class ColonyService {

    def createColony(String name)
	{
		Colony colony = new Colony([name: name])
		colony.save()
		
		return colony
    }
	
	def addMember(Colony c, Member m)
	{
		c.addToMembers(m)
		c.save()
	}
}
