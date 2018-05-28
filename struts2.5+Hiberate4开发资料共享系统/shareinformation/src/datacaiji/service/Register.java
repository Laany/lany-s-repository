package datacaiji.service;

import com.opensymphony.xwork2.Action;

import datacaiji.bean.Role;
import datacaiji.bean.User;
import datacaiji.dao.UserDAOImp;

public class Register implements Action{
	private final int usergrade = 1;
	private String userid;
	private String userpassword;
	private String username;
	private String usersex;
	private String userqq;
	private String userphone;
	private String useraddress;
	private String result;
		
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
	public int getUsergrade() {
		return usergrade;
	}

	@Override
	public String execute() throws Exception {
		UserDAOImp udi = new UserDAOImp();
		User users = udi.queryByID(userid);
		
		if (users == null) {
			User user = new User();
			user.setUserid(userid);
			user.setUserpassword(userpassword);
			user.setUsername(username);
			user.setUsersex(usersex);
			user.setUserqq(userqq);
			user.setUserphone(userphone);
			user.setUseraddress(useraddress);
			udi.saveOrUpdate(user);
			result = "账号注册成功";
			return SUCCESS;
		}
		result = "账号已存在注册失败";
		return ERROR;
	}
}
