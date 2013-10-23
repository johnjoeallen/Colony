package colony

class Category {
	String id
	String name
	
	static hasMany = [categories: Category]

	static mapping = {
		id generator: 'uuid'
	}
	
    static constraints = {
    }
}
