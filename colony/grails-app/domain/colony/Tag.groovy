package colony

class Tag {
	String id
	String name
	Date created = new Date()
	
	static mapping = {
		id generator: 'uuid'
	}
		
    static constraints = {
    }
}
