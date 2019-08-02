package lab.spring.parking.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lab.spring.parking.model.*;


@Repository
public class WoowaDAO {
	@Autowired
	SqlSession sqlSession;

	/* user */
	public UserVO login(String useremail, String userpwd) {// login
		Object obj = null;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("useremail", useremail);
		map.put("userpwd", userpwd);
		obj = sqlSession.selectOne("lab.mybatis.mapper.UserMapper.login", map);
		return (UserVO) obj;
	}

	public int addUser(UserVO user) {// join to member
		if (user.getEmail_dns().length() > 1) {
			user.setUseremail(user.getEmail() + "@" + user.getEmail_dns());
		} else {
			user.setUseremail(user.getEmail() + "@" + user.getDns_Add());
		}
		System.out.println(user);
		return sqlSession.insert("lab.mybatis.mapper.UserMapper.addUser", user);
	}
	public int removeUser(final String uemail) {//user 탈퇴
		return sqlSession.delete("lab.mybatis.mapper.UserMapper.removeUser", uemail);
	}


	/* NOTICE */
	public int addNotice(NoticeVO notice) { //공지 저장
		return sqlSession.insert("lab.mybatis.mapper.NoticeMapper.addNotice", notice);		
	}
	public List<NoticeVO> getNoticeList(){		
		return sqlSession.selectList("lab.mybatis.mapper.NoticeMapper.getNoticeList");
	}
	
	
	/* 주차장 정보 */
	public List<PrkplceVO> findAllList() {
		return sqlSession.selectList("lab.mybatis.mapper.ParkingLot.getAllList");
	}

}
