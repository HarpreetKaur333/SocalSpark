package Model;

public class SuggestedFriends {
	
	private int FrndId;	
	private int UserId;
	private String Email;
	private String FullName;
	private int Status;
	
	public int getFrndId() {
		return FrndId;
	}
	public void setFrndId(int frndId) {
		FrndId = frndId;
	}
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public SuggestedFriends(int frndId, int userId, String email, String fullName, int status) {
		super();
		this.FrndId = frndId;
		this.UserId = userId;
		this.Email = email;
		this.FullName = fullName;
		this.Status = status;
	}
	@Override
	public String toString() {
		return "SuggestedFriends [FrndId=" + FrndId + ", UserId=" + UserId + ", Email=" + Email + ", FullName="
				+ FullName + ", Status=" + Status + "]";
	}
	

}
