package Model;

import java.util.ArrayList;

import Model.User;

public class User {
	private int UserId;
	private String firstName;
	private String LastName;
	private String Email;
	private String Password;
	
	//here create array list for friend
	private ArrayList<User> friendsList  = new ArrayList<>();
	 private ArrayList<Post> post  = new ArrayList<>();
	 
	public User(String Email, String Password) {
		super();
		this.Email = Email;
		this.Password = Password;
	}

	public User(int UserId,String firstName, String Password,String Email ) {
		super();
		this.UserId=UserId;
		this.firstName = firstName;		
		this.Email=Email;
		this.Password = Password;
	}
	
		public User(String firstName, String LastName,String Email ) {
		super();
		this.firstName = firstName;	
		this.LastName = LastName;
		this.Email=Email;
		
	}

	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", LastName=" + LastName + ", Email=" + Email + ", Password=" + Password
				+ "]";
	}

	//getter setter for friends list
	public ArrayList<User> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(ArrayList<User> friendsList) {
		this.friendsList = friendsList;
	}
	//create getter setter for post
	public ArrayList<Post> getPost() {
		return post;
	}
	public void setPost(ArrayList<Post> post) {
		this.post = post;
	}
	    
	
}
