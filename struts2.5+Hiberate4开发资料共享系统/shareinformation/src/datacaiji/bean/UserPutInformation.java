package datacaiji.bean;


public class UserPutInformation {  //用户上传
	private int id; //自增
	private String userid;  //user的主键  下载的用户
	private String infid;  //information的主键 上传的文件 
	private String date; //上传的日期
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getInfid() {
		return infid;
	}
	public void setInfid(String infid) {
		this.infid = infid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
