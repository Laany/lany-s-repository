package datacaiji.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import datacaiji.bean.Role;
import datacaiji.bean.User;

public class UserDAOImp implements UserDAO{

	@Override
	public boolean saveOrUpdate(User user) {     //添加用户
		boolean ret = false;
		Session session = null;
		Transaction transaction=null;
		Role role = null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			role = (Role) session.load(Role.class, 1);
			user.setRole(role);
			session.saveOrUpdate(user);
			transaction.commit();
			ret = true;
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return ret;
	}

	@Override
	public boolean delete(String userid) {   //删除用户
		boolean ret = false;
		Session session = null;
		Transaction transaction=null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			User user = (User) session.load(User.class, userid);
			session.delete(user);
			transaction.commit();
			ret = true;
		}catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return ret;
	}

	@Override
	public User queryByID(String id) {    //通过id查找用户
		User user = null;
		Session session = null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			user = (User) session.get(User.class, id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return user;
	}

	@Override
	public List<User> queryByName(String name) {    //通过名字查找用户
		List<User> ret = null; 
		Session session = null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			Criteria c1 = session.createCriteria(User.class);
			c1.add(Restrictions.eq("StuName", name));
			ret = c1.list();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return ret;
	}

	@Override
	public boolean updateAdmin(User user) {
		boolean ret = false;
		Session session = null;
		Transaction transaction=null;
		Role role = null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			if (user.getRole().getRolegrade() == 1) {
				role = (Role) session.load(Role.class, 2);
				user.setRole(role);
				session.saveOrUpdate(user);
			}
			else {
				role = (Role) session.load(Role.class, 1);
				user.setRole(role);
				session.saveOrUpdate(user);
			}
			transaction.commit();
			ret = true;
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return ret;	}

}
