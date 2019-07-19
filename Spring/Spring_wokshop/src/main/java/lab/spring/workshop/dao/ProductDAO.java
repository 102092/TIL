package lab.spring.workshop.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lab.spring.workshop.model.ProductVO;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public int addPro(ProductVO pro) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession.insert("lab.mybatis.user.ProductMapper.addPro", pro);

	}
	public ProductVO getPro(String pcode) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession.selectOne("lab.mybatis.user.ProductMapper.getPro", pcode);

	}
	
	public List<ProductVO> findProList() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession.selectList("lab.mybatis.user.ProductMapper.getProList");

	}

	public int updatePro(ProductVO pro) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession.update("lab.mybatis.user.ProductMapper.modifyPro", pro);

	}

	public int removePro(final String pcode) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession.delete("lab.mybatis.user.ProductMapper.removePro", pcode);

	}

}
