package datacaiji.bean;

public class Information {
	private String fileid;
	private String filename;
	private String filesize;   //文件大小
	private String path;   //文件的路径
	private int frequency; //文件被下载的次数
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Information){
			Information information = (Information) obj;
			if (information.getFileid().equals(this.fileid)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.fileid.hashCode();
	}

	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	
}
