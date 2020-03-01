package lab.spring.parking.model;

import java.sql.Date;

public class NoticeVO {
	private String managername; //managername으로 게시글 등록
	private int bid; //공지번호
	private String subject; //공지제목
	private Date idate; //공지날짜
	private String contents; //공지내용
	//private ArrayList<FileInfoVO> files; //공지파일
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
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
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
//	public ArrayList<FileInfoVO> getFiles() {
//		return files;
//	}
//	public void setFiles(ArrayList<FileInfoVO> files) {
//		this.files = files;
//	}
	@Override
	public String toString() {
		return "ㅇㅏ무무";
//		return "NoticeVO [managername=" + managername + ", bid=" + bid + ", subject=" + subject + ", idate=" + idate
//				+ ", contents=" + contents +  ", fileYN=" + fileYN + ", rcount=" + rcount
//				+ ", vcount=" + vcount + "]";
	}


}



