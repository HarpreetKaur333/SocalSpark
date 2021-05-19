package Model;

public class Notifications {
	private int id;
	private int type;
	private String FromUserId;
	private String ToUserId;
	private String Username;
	private String TouserName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getTouserName() {
		return TouserName;
	}
	public void setTouserName(String touserName) {
		TouserName = touserName;
	}
	public Notifications(int type, String fromUserId, String toUserId, String username, String touserName) {
		super();
		this.type = type;
		FromUserId = fromUserId;
		ToUserId = toUserId;
		Username = username;
		TouserName = touserName;
	}
	@Override
	public String toString() {
		return "Notifications [id=" + id + ", type=" + type + ", FromUserId=" + FromUserId + ", ToUserId=" + ToUserId
				+ ", Username=" + Username + ", TouserName=" + TouserName + "]";
	}

	
	
}
