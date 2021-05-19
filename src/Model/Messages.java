package Model;

import java.sql.Date;

public class Messages {
	
	private String FromUserId;
	private String ToUserId;
	private String message;
	
	
	
	public Messages(String fromUserId, String toUserId, String message) {
		super();
		FromUserId = fromUserId;
		ToUserId = toUserId;
		this.message = message;
	}
	public String getFromUserId() {
		return FromUserId;
	}
	public void setFromUserId(String fromUserId) {
		FromUserId = fromUserId;
	}
	public String getToUserId() {
		return ToUserId;
	}
	public void setToUserId(String toUserId) {
		ToUserId = toUserId;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Messages [FromUserId=" + FromUserId + ", ToUserId=" + ToUserId + ", message=" + message+ "]";
	}
	
	
}
