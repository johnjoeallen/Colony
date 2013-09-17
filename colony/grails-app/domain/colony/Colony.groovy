package colony

import java.util.Date;

class Colony {
	String id
	String	name
	Date	created = new Date()
	
	static hasMany = [members: Member, entries: Entry]

	static mapping = {
		id generator: 'uuid'
	}
		
    static constraints = {
		created nullable:true
    }
}
