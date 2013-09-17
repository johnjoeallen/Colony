package colony

import java.util.Date;

class Entry {
	String id
	Post post
	Date created = new Date()
	
	static mapping = {
		id generator: 'uuid'
	}
	
    static constraints = {
    }
}
