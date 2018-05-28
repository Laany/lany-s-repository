package datacaiji.dao;

import datacaiji.bean.Role;
import datacaiji.bean.User;

public class Test {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAOImp();
		User user = userDAO.queryByID("root");
		System.out.println(user.getRole().getRolegrade());
	}
}
