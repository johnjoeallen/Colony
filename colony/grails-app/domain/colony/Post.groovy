package colony

class Post {
	String id
	String type
	VersionedPost current
	static belongsTo = [member: Member]
	
	static mapping = {
		id generator: 'uuid'
	}
		
    static constraints = {
		type nullable: true
    }
}
