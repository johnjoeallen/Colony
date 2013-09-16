package colony

class Colony {
	String id
	String	name
	
	static hasMany = [members: Member, posts: Post]

	static mapping = {
		id generator: 'uuid'
	}
		
    static constraints = {
    }
}
