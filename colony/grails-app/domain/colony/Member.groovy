package colony

class Member {
	String	identity	// email address
	String	fullname
	Date created = new Date()
	Date lastLogin = new Date()
  
	static hasMany = [posts: Post]
	
    static constraints = {
    }
}
