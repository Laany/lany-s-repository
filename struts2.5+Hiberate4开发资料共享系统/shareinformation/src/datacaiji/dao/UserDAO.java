package datacaiji.dao;

import java.util.List;

import datacaiji.bean.User;

public interface UserDAO {
	public abstract boolean saveOrUpdate(User user); 
	public abstract boolean delete(String userid);
	public abstract User queryByID(String id);
	public abstract List<User> queryByName(String name);
	public abstract boolean updateAdmin(User user);
}
