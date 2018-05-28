package datacaiji.service;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import datacaiji.bean.User;
import datacaiji.dao.UserDAOImp;

public class Login implements Action{
	private String userid;
	private String userpassword;
	private String code;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String execute() throws Exception{
		UserDAOImp udi = new UserDAOImp();
		User user = udi.queryByID(userid);
		Map<String, Object> session = ActionContext.getContext().getSession();
		String yzm = (String) session.get("yzm");
		
		if (user!=null) {
			if (userpassword.equals(user.getUserpassword())){
				if (code.equals(yzm)) {
					session.put("user", user);
					return SUCCESS;
				}
				result = "登陆失败，验证码错误";
				return ERROR;
			}
			result = "登陆失败，密码错误";
			return ERROR;
		}
		result = "登陆失败，用户不存在";
		return ERROR;
	}
}
