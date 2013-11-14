package colony

import java.util.Date;

class Member
{
	String id
	String	name
	Date	created = new Date()
	Colony	colony
	
	static hasMany = [stream: Entry]
	
	static mapping =
	{ id generator: 'uuid' }

	static constraints =
	{
		colony nullable: true
	}
}
