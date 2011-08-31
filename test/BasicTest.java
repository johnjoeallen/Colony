import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest
	extends UnitTest 
{
	@Test
	public void createAndRetrieveUser() 
	{
		final String userName = "John Allen";
	    // Create a new user and save it
	    new User("johnjoeallen@gmail.com", "secret", userName).save();
	    
	    // Retrieve the user with e-mail address johnjoeallen@gmail.com
	    User user = User.find("byEmail", "johnjoeallen@gmail.com").first();
	    
	    // Test 
	    assertNotNull(user);
	    assertEquals(userName, user.fullname);
	}
}
