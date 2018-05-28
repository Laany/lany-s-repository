package datacaiji.service;

import com.opensymphony.xwork2.ActionSupport;

import datacaiji.bean.InfPageBean;

public class InformationAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private InformationService InformationService = new InformationService();
	private int page;
	private InfPageBean infpageBean;

	@Override
	public String execute() throws Exception {
		infpageBean = InformationService.getPageBean(5, page);
		return SUCCESS;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public InfPageBean getInfpageBean() {
		return infpageBean;
	}

	public void setInfpageBean(InfPageBean infpageBean) {
		this.infpageBean = infpageBean;
	}
	
}
