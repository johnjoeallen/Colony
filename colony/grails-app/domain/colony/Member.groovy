package colony

class Member {
	String id
	String	identity	// email address
	String	fullname
	Date created = new Date()
	Date lastLogin = new Date()
  
	static mapping = {
		id generator: 'uuid'
	}
		
	static hasMany = [posts: Post]
	
    static constraints = {
    }
}
