package datacaiji.service;

import java.util.List;

import datacaiji.bean.InfPageBean;
import datacaiji.bean.Information;
import datacaiji.dao.FindAllDao;
import datacaiji.dao.FindAllDaoImp;

public class InformationService {
	private FindAllDao findAllDao = new FindAllDaoImp();
	
	public InfPageBean getPageBean(int pageSize, int page)  
    {  
        InfPageBean infpageBean = new InfPageBean();  
          
        int allRows = (int)findAllDao.countInformation();  
        int totalPage = infpageBean.getTotalPages(pageSize, allRows); //总页数 
        int currentPage = infpageBean.getCurPage(page);  //当前页数
        int offset = infpageBean.getCurrentPageOffset(pageSize, currentPage);  
        List<Information> list = findAllDao.queryIfoByPage(offset, pageSize);  
          
        infpageBean.setList(list);  
        infpageBean.setAllRows(allRows);  
        infpageBean.setCurrentPage(currentPage);  
        infpageBean.setTotalPage(totalPage);  
          
        return infpageBean;  
    }  
}
