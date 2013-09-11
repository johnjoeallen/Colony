package colony

class Comment {

	static belongsTo = [member: Member]
	static hasMany = [versions: VersionedComment]
	
    static constraints = {
    }
}
