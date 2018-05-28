package datacaiji.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String filename;
	private InputStream mm;
	private String filePath;

	@Override
	public String execute() throws Exception {
		String fn = filePath + filename;
		if (!new File(fn).exists()) {
			return Action.ERROR;
		}
		this.mm = new FileInputStream(new File(fn));
		return Action.SUCCESS;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public InputStream getMm() {
		return mm;
	}

	public void setMm(InputStream mm) {
		this.mm = mm;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
