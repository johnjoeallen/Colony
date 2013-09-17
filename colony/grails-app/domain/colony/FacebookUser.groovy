package colony

class FacebookUser {
  long uid
  String accessToken
  Date accessTokenExpires
  static belongsTo = [user: Member] //connected to main Spring Security domain

  static constraints = {
    uid unique: true
  }
}