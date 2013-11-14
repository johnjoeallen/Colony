package colony

import java.util.Date

class Colony
{
	String id
	String	name
	Date	created = new Date()
	Boolean	open = false
	
	static hasMany = [entries: Entry, followers: Member, contributors: Member]

	static mapping =
	{ id generator: 'uuid' }

	static constraints =
	{
		created nullable:true
		open nullable: true
	}
}
