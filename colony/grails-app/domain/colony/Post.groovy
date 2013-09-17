package colony

import java.util.Date;

class Post {
	String id
	String type
	VersionedPost current
	Date	created = new Date()
	
	transient Map<String, Colony> colonies = new HashMap<String, Colony>()
	transient Map<String, Member> members = new HashMap<String, Member>()
	
	static belongsTo = [member: Member]
	static transients = ["colonies", "members"]
	
	static mapping = {
		id generator: 'uuid'
	}
		
    static constraints = {
		type nullable: true
		created nullable:true
    }
}
