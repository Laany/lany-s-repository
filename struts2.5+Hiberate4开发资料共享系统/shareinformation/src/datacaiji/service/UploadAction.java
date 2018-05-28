package datacaiji.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import datacaiji.bean.Information;
import datacaiji.bean.User;
import datacaiji.dao.InformationDao;
import datacaiji.dao.InformationDaoImp;

public class UploadAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String filename;
	private String info;
	private String savePath;
	private double filesize;
	
	@Override
	public String execute() throws Exception {
		String fn="";
		if (filename==null || filename.equals("") || filename.trim().equals("") || filename.equals("修改文件名")) {
			filename = uploadFileName;
			fn = savePath+filename;
		}
		else {
			fn = savePath+filename;
		}
		
		if (new File(fn).exists()) {
			info="上传的文件已经存在，请重新命名";
		}
		else {
			FileInputStream inputStream = new FileInputStream(upload);
			FileOutputStream outputStream = new FileOutputStream(new File(fn));
			byte[] buffer = new byte[1024];
			int count=0;
			while ((count=inputStream.read(buffer))>0) {
				outputStream.write(buffer, 0, count);
			}
			inputStream.close();
			outputStream.close();
			
			Map<String, Object> session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");
			
			filesize = new File(fn).length();
			filesize = filesize/(1024*1024);
			System.out.println(String.format("%.2f", filesize)+"MB"); //计算文件大小
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String time = sdf.format(new Date());
			
			Information information = new Information();
			information.setFileid(user.getUserid() + time.substring(0, 4) + time.substring(5, 7) + time.substring(8,10) + 
					time.substring(11,13) + time.substring(14,16) + time.substring(17,19));
			information.setFilename(filename);
			information.setFilesize(String.format("%.2f", filesize) + "MB");
			information.setFrequency(0);
			information.setPath(savePath);
			
			InformationDao informationDao = new InformationDaoImp();
			informationDao.saveOrUpdate(information);
			
			info="上传成功";
		}
		return Action.SUCCESS;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	
}
