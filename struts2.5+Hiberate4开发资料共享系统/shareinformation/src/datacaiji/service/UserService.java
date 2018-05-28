package datacaiji.service;

import java.util.List;

import datacaiji.bean.User;
import datacaiji.bean.UserPageBean;
import datacaiji.dao.FindAllDao;
import datacaiji.dao.FindAllDaoImp;

public class UserService {
private FindAllDao findAllDao = new FindAllDaoImp();
	
	public UserPageBean getPageBean(int pageSize, int page)  
    {  
        UserPageBean userpageBean = new UserPageBean();  
          
        int allRows = (int)findAllDao.countInformation();  
        int totalPage = userpageBean.getTotalPages(pageSize, allRows); //总页数 
        int currentPage = userpageBean.getCurPage(page);  //当前页数
        int offset = userpageBean.getCurrentPageOffset(pageSize, currentPage);  
        List<User> list = findAllDao.queryUserByPage(offset, pageSize);  
          
        userpageBean.setList(list);  
        userpageBean.setAllRows(allRows);  
        userpageBean.setCurrentPage(currentPage);  
        userpageBean.setTotalPage(totalPage);  
          
        return userpageBean;  
    }  
}
