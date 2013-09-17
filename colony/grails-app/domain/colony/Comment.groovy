package colony

class Comment {
	String id
	String content
	Date created = new Date()
	
	static belongsTo = [member: Member]
	static hasMany = [versions: VersionedComment]
	
	static mapping = {
		id generator: 'uuid'
	}
		
    static constraints = {
    }
}
