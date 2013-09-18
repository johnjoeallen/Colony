package colony

class Member
{

	transient springSecurityService
	String id
	String username
	String nickname
	String email
	String fullname
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	Date created = new Date()
	Date lastLogin = new Date()

	static hasMany = [posts: Post]

	static constraints =
	{
		username blank: false, unique: true
		password blank: false
		nickname (nullable: true, blank: true, unique: true)
		fullname (nullable: true, blank: true)
		email (nullable: true, blank: true, unique: true)
		password nullable: true
		enabled nullable: true
		accountExpired nullable: true
		accountLocked nullable: true
		passwordExpired nullable: true
	}

	static mapping =
	{
		id generator: 'uuid'
		password column: '`password`'
	}

	String getNickName()
	{
		if (nickname?.length() > 0)
		{
			return nickname
		}
		
		return username;
	}
	
	String getDisplayName()
	{
		if (fullname?.length() > 0)
		{
			return fullname
		}
		
		return username;
	}

	Set<Role> getAuthorities()
	{
		MemberRole.findAllByMember(this).collect { it.role } as Set
	}

	def beforeInsert()
	{
		encodePassword()
	}

	def beforeUpdate()
	{
		if (isDirty('password'))
		{
			encodePassword()
		}
	}

	protected void encodePassword()
	{
		password = springSecurityService.encodePassword(password)
	}
}
