package colony

class Post {
	static belongsTo = [member: Member]
	static hasMany = [versions: VersionedPost]
	
    static constraints = {
    }
}
