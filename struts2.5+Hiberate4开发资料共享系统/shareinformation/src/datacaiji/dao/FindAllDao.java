package datacaiji.dao;

import java.util.List;

import datacaiji.bean.Information;
import datacaiji.bean.User;

public interface FindAllDao {
	public List<User> FindAllUser();
	public List<Information> FindAllFile();
	public List<User> queryUserByPage(int offset, int pageSize);//第一条记录索引   每页需要显示的数据
	public List<Information> queryIfoByPage(int offset, int pageSize);
	public long countUser();
	public long countInformation();
}
