package colony

class VersionedPost {
	String id
	String title
	String content
	Date	created = new Date()
	VersionedPost previous
	
	static belongsTo = [member: Member]
	static hasMany = [comments: Comment, tags: Tag]
	
	static mapping = {
		id generator: 'uuid'
		content sqlType: "text"
	}
	
    static constraints = {
		content nullable: false
		created nullable: false
		previous nullable: true
		member nullable: true
    }
}
