package lab.spring.workshop.service;

import java.util.List;

import lab.spring.workshop.model.ProductVO;

public interface ProductService {
	
	public int addPro(ProductVO pro);
	
	public int updatePro(ProductVO pro);

	public int removePro(String pid);
	
	public List<ProductVO> findProList();
	
	public ProductVO getPro(String pid);


}
