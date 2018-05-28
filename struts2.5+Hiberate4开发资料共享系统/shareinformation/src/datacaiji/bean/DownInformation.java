package datacaiji.bean;

public class DownInformation {
	private String id; //自增
	private String userid;  //user的主键  下载的用户
	private String infid;  //information的主键 下载的文件
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
}
