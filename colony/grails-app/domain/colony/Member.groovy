package colony

class Member {

	transient springSecurityService
	String id
	String username
	String email
	String fullname
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	Date created = new Date()
	Date lastLogin = new Date()

	Member()
	{
		email = "*"
		fullname = "*"
	}
	
	static hasMany = [posts: Post]
	
	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		id generator: 'uuid'
		password column: '`password`'

		username nullable: true
		fullname nullable: true
		email nullable: true
		password nullable: true
		enabled nullable: true
		accountExpired nullable: true
		accountLocked nullable: true
		passwordExpired nullable: true
	
	}

	Set<Role> getAuthorities() {
		MemberRole.findAllByMember(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
