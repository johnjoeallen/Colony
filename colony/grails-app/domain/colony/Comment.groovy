package colony

class Comment {
	String id
	
	static belongsTo = [member: Member]
	static hasMany = [versions: VersionedComment]
	
	static mapping = {
		id generator: 'uuid'
	}
		
    static constraints = {
    }
}
