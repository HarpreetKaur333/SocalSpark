package Model;

public class RegisterUser {
	private int UserId;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	
	public RegisterUser(int UserId,String firstName, String lastName, String email, String password) {
		super();
		this.UserId=UserId;
		this.FirstName = firstName;
		LastName = lastName;
		Email = email;
		Password = password;
	}
//	public RegisterUser(int UserId, String firstName, String lastName, String email) {
//		super();
//		this.UserId=UserId;
//		this.FirstName = firstName;
//		LastName = lastName;
//		Email = email;
//	
//	}
	
	public String getFirstName() {
		return FirstName;
	}
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	@Override
	public String toString() {
		return "firstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", Password="
				+ Password;
	}
	
	
}
