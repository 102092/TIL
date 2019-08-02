package lab.spring.parking.service;

import java.util.List;

import lab.spring.parking.model.*;


public interface WoowaService {
	
	//user 
	public UserVO login(String uemail, String upwd);
	public int addUser(UserVO user);
	//NOTICE
	public List<NoticeVO> getNoticeList();
	public int addNotice(NoticeVO notice);
	//parklot
	public List<PrkplceVO> findAllList();
	

	
}
