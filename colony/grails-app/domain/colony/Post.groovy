package colony

class Post {
	String type
	VersionedPost current
	static belongsTo = [member: Member]
	
    static constraints = {
		type nullable: true
    }
}
