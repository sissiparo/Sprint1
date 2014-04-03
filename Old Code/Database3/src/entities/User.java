package entities;
import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the user database table.
 * 
 */

@NamedQueries({
	@NamedQuery(name = "User.findUserName", query = "select o from User o where o.userName=:userName"),
	@NamedQuery(name = "User.findAll", query = "select o from User o")
})

@Entity
@XmlRootElement
@Table (name="User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;

	@Column
	private String employeeNumber;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String password;
	@Column
	private String userName;
	@Column
	private String userType;

    public User() {
    }

    public User(String userName, String password, String employeeNumber, String firstName, String lastName, String userType ){
		
		super();
		this.userName=userName;
		this.password=password;
		this.employeeNumber=employeeNumber;
		this.firstName=firstName;
		this.lastName=lastName;
		this.userType=userType;
		
	}
    
	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEmployeeNumber() {
		return this.employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}