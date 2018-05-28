package datacaiji.service;

import com.opensymphony.xwork2.ActionSupport;
import datacaiji.bean.UserPageBean;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserService();
	private int page;
	private UserPageBean userPageBean;

	@Override
	public String execute() throws Exception {
		userPageBean = userService.getPageBean(5, page);
		return SUCCESS;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public UserPageBean getUserPageBean() {
		return userPageBean;
	}

	public void setUserPageBean(UserPageBean userPageBean) {
		this.userPageBean = userPageBean;
	}
}
