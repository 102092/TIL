package lab.spring.parking.model;

public class FileInfoVO {

	private int fid; 
	private int rbid; //공지번호
	private String filename; //파일명
	private String fileType; //확장자
	private String savedfile; //파일저장

	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getRbid() {
		return rbid;
	}
	public void setRbid(int rbid) {
		this.rbid = rbid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getSavedfile() {
		return savedfile;
	}
	public void setSavedfile(String savefile) {
		this.savedfile = savefile;
	}
	public String toString() {
		return "FileInfoVO [fid=" + fid + ", rbid=" + rbid + ", filename=" + filename + ", fileType=" + fileType + "]";
	}

}
