package models;
 
import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;
 
@Entity
@Table (name="swarm_user")
public class User 
	extends Model 
{
    public String email;
    public String password;
    public String fullname;
    public boolean isAdmin;
    
    public User(String email, String password, String fullname) 
    {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.isAdmin = false;
    }
 }