package colony

class Colony {
	String	name
	
	static hasMany = [members: Member, posts: Post]
	
    static constraints = {
    }
}
