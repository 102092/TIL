package lab.spring.parking.model;

import java.util.ArrayList;
import java.util.Date;

public class BoardVO {
	
	private int bid; //공지번호
	private String subject; //공지제목
	private String manager; //user_email-> manager_email 연결
	private Date idate; //공지날짜
	private String contents; //공지내용
	private ArrayList<FileInfoVO> files; //공지파일
	private String fileYN;
	private int rcount; //조회수
	private int vcount;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Date getIdate() {
		return idate;
	}
	public void setIdate(Date idate) {
		this.idate = idate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getFileYN() {
		return fileYN;
	}
	public void setFileYN(String fileYN) {
		this.fileYN = fileYN;
	}
	public int getRcount() {
		return rcount;
	}
	public void setRcount(int rcount) {
		this.rcount = rcount;
	}
	public int getVcount() {
		return vcount;
	}
	public void setVcount(int vcount) {
		this.vcount = vcount;
	}
	public ArrayList<FileInfoVO> getFiles() {
		return files;
	}
	public void setFiles(ArrayList<FileInfoVO> files) {
		this.files = files;
	}

	public String toString() {
		return "ex [bid=" + bid + ", subject=" + subject + ", manager=" + manager + ", idate=" + idate + ", contents="
				+ contents + ", fileYN=" + fileYN + ", rcount=" + rcount + ", vcount=" + vcount + ", files=" + files
				+ "]";
	}

}



