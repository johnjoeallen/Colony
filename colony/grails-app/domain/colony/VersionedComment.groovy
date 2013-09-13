package colony

import java.util.Date;

class VersionedComment {
	String content
	Date	created
	VersionedComment previous
	
	static belongsTo = [comment: Comment]
	
	static mapping = {
		content sqlType: "text"
	}
	
    static constraints = {
		content nullable: false
		created nullable: false
		previous nullable: true
    }
}
