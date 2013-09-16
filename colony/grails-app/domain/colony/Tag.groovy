package colony

class Tag {
	String id
	
	static mapping = {
		id generator: 'uuid'
	}
		
    static constraints = {
    }
}
