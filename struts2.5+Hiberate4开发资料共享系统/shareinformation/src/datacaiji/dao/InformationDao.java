package datacaiji.dao;

import datacaiji.bean.Information;

public interface InformationDao {
	public abstract boolean delete(String fileid);
	public abstract Information findByfile(String filename);
	public abstract Information findByfileid(String fileid);
	public abstract Information findByuser(String username);
	public abstract boolean saveOrUpdate(Information information);
}
