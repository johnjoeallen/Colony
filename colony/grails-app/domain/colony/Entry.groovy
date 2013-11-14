package colony

class Entry
{
	String	id
	String	content
	Member	owner

	static mapping =
	{ id generator: 'uuid' }

	static constraints =
	{
	}
}
