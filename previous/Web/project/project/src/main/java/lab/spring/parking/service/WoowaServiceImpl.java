package lab.spring.parking.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import lab.spring.parking.dao.WoowaDAO;
import lab.spring.parking.model.*;

@Service("WoowaService")
public class WoowaServiceImpl implements WoowaService{
	@Autowired
	private WoowaDAO dao;
	
	public UserVO login(String useremail, String userpwd) {
		return dao.login(useremail, userpwd);
	}

	public int addUser(UserVO user) {
		return dao.addUser(user);
	}

	public List<PrkplceVO> findAllList() {
		return dao.findAllList();
	}
	
	public int addMyFav(MyFavVO vo) {
		return dao.addMyFav(vo);
	}
	
	

}
