package lab.spring.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.workshop.dao.ProductDAO;
import lab.spring.workshop.model.ProductVO;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO dao;

	public int updatePro(ProductVO pro) {
		// TODO Auto-generated method stub
		return dao.updatePro(pro);
	}

	public int removePro(String pid) {
		// TODO Auto-generated method stub
		return dao.removePro(pid);
	}

	public List<ProductVO> findProList() {
		// TODO Auto-generated method stub
		return dao.findProList();
	}
	public ProductVO getPro(String pid) {
		// TODO Auto-generated method stub
		return dao.getPro(pid);
	}

	public int addPro(ProductVO pro) {
		// TODO Auto-generated method stub
		return dao.addPro(pro);
	}




}
