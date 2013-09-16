package colony

import java.util.Date;

class VersionedComment 
{
	String id
	String content
	Date	created
	VersionedComment previous
	
	static belongsTo = [comment: Comment]
	
	static mapping = {
		id generator: 'uuid'
		content sqlType: "text"
	}
	
    static constraints = {
		content nullable: false
		created nullable: false
		previous nullable: true
    }
}
