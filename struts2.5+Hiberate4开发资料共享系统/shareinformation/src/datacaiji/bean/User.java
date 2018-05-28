package datacaiji.bean;

public class User {
	private String userid;
	private String userpassword;
	private String username;
	private String usersex;
	private String userqq;
	private String userphone;
	private String useraddress;
	private Role role;
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User){
			User user = (User) obj;
			if (user.getUserid().equals(this.userid)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.userid.hashCode();
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUserqq() {
		return userqq;
	}
	public void setUserqq(String userqq) {
		this.userqq = userqq;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
