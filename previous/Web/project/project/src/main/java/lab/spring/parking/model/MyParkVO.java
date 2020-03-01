package lab.spring.parking.model;

public class MyParkVO {
	private String Ga;	
	private String Ha;
	public String getGa() {
		return Ga;
	}
	public void setGa(String ga) {
		Ga = ga;
	}
	public String getHa() {
		return Ha;
	}
	public void setHa(String ha) {
		Ha = ha;
	}
	@Override
	public String toString() {
		return "MyParkVO [Ga=" + Ga + ", Ha=" + Ha + "]";
	}
	
	
	
}
