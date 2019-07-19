package lab.spring.workshop.model;

public class ProductVO {
	private String pcode;
	private String pname;
	private int price;
	private int quant;
	private String pdesc;

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "상품코드: " + pcode + " 상품명 : " + pname + " 가격 : " + price + " 설명 : " + pdesc;
	}

}
