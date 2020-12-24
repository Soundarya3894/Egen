package demo;
import java.util.HashMap;

public class CarpetStyle {

	public HashMap<String, Double> map = new HashMap<String, Double>();
	public String userChoice;
	public CarpetStyle(String userChoice) {
		map.put("Velvet", 55.00);
		map.put("Saxony",43.00);
		map.put("Frieze", 25.00);
		map.put("Shag", 14.00);
		map.put("Cable", 9.00);
		// TODO Auto-generated constructor stub
	}
	
	public double getCarpetCost () {
		try {
			return map.get(userChoice);
			
		}catch(Exception e) {}
		
		return -1;
	}
}
