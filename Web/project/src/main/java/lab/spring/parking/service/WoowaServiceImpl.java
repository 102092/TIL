package lab.spring.parking.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import lab.spring.parking.dao.WoowaDAO;
import lab.spring.parking.model.*;

@Service("woowaService")
public class WoowaServiceImpl implements WoowaService{
	@Autowired
	private WoowaDAO dao;

	/* USER */
	public UserVO login(String useremail, String userpwd) {
		return dao.login(useremail, userpwd);
	}
	public int addUser(UserVO user) {
		return dao.addUser(user);
	}

	/* Notice */
	public List<NoticeVO> getNoticeList() {
		return dao.getNoticeList();
	}
	public int addNotice(NoticeVO notice) {		
		return dao.addNotice(notice);
	}

	/* PARKING LOT */
	public List<PrkplceVO> findAllList() {
		return dao.findAllList();
	}


}
