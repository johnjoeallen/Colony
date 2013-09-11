package colony

class VersionedPost {
	String title
	String content
	Date	created
	VersionedPost previous
	
	static belongsTo = [post: Post]
	
	static hasMany = [comments: Comment, tags: Tag]
	
    static constraints = {
		content nullable: false
		created nullable: false
		previous nullable: true
    }
}
