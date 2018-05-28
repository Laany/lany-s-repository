package datacaiji.service;

import java.io.File;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import datacaiji.bean.Information;
import datacaiji.bean.User;
import datacaiji.dao.InformationDao;
import datacaiji.dao.InformationDaoImp;
import datacaiji.dao.UserDAO;
import datacaiji.dao.UserDAOImp;

public class SuperAdministrator {
	private String userid;
	private String fileid;
	private String result;
	
	public String addordeletAdministrator() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user1 = (User) session.get("user");
		int i = user1.getRole().getRolegrade();
		if (i > 2) {
			UserDAO userDAO = new UserDAOImp();
			User user = userDAO.queryByID(userid);
			userDAO.updateAdmin(user);
			result = "操作成功";
			return "user";
		}
		else {
			result = "权限不够删除失败";
			return "user";
		}
	}
	
	public String deleteUser() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		int i = user.getRole().getRolegrade();
		if (i > 1) {
			UserDAO userDAO = new UserDAOImp();
			userDAO.delete(userid);
			result = "删除成功";
			return "user";
		}
		else {
			result = "权限不够删除失败";
			return "user";
		}
	}
	
	public String deleteInformation() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		int i = user.getRole().getRolegrade();
		if (i > 1) {
			InformationDao informationDao = new InformationDaoImp();
			Information information = informationDao.findByfileid(fileid);
			File file = new File(information.getPath()+information.getFilename());
			boolean k = file.delete();
			if (k) {
				informationDao.delete(fileid);
				result = "文件删除成功";
			}
			return "information";
		}
		else {
			result = "权限不够删除失败";
			return "information";
		}
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFileid() {
		return fileid;
	}
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
