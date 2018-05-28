package datacaiji.dao;

public class Pager {
	 private int pageNow;      //当前页  
     private int pageSize;   //每页显示多少条记录  
     private int totalPage;    //共有多少页  
     private int totalSize;      //共有多少条记录  
     private boolean hasFirst;   //是否有首页  
     private boolean hasPre;     //是否有前一页  
     private boolean hasNext;    //是否有下一页  
     private boolean hasLast;    //是否有最后一页 
     
     public Pager(int pageNow, int totalSize){  
         this.pageNow = pageNow;  
         this.totalSize = totalSize;  
     }

	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public boolean isHasFirst() {
		return hasFirst;
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	public boolean isHasPre() {
		return hasPre;
	}
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	public boolean isHasNext() {
		return hasNext;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	
	public boolean isHasLast() {
		return hasLast;
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
}
