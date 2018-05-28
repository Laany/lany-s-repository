package datacaiji.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import datacaiji.bean.Information;


public class InformationDaoImp implements InformationDao{

	@Override
	public boolean delete(String fileid) {    //通过id删除文件
		boolean ret = false;
		Session session = null;
		Transaction transaction=null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			Information information = (Information) session.get(Information.class, fileid);
			session.delete(information);
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
	public Information findByfile(String filename) {    //通过文件名查找文件
		Information information = null;
		Session session = null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			Criteria criteria = session.createCriteria(Information.class);    
	        criteria.add(Restrictions.eq("filename", filename));  
			information = (Information) criteria.uniqueResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return information;
	}

	@Override
	public Information findByuser(String username) {    //通过用户名查找文件
		Information information = null;
		Session session = null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			Criteria criteria = session.createCriteria(Information.class);    
	        criteria.add(Restrictions.eq("username", username));  
			information = (Information) criteria.uniqueResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return information;
	}

	@Override
	public boolean saveOrUpdate(Information information) {     //存入文件
		boolean ret = false;
		Session session = null;
		Transaction transaction=null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(information);
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
	public Information findByfileid(String fileid) {
		Information information = null;
		Session session = null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			Criteria criteria = session.createCriteria(Information.class);    
	        criteria.add(Restrictions.eq("fileid", fileid));  
			information = (Information) criteria.uniqueResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return information;
	}

}
