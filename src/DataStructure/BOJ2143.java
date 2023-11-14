package DataStructure;

import java.util.HashMap;
import java.util.Map;

public class BOJ2143 {
	
	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<>();
		
		
		map.forEach((key, value) -> {
		    System.out.println(key + " : " + value);
		});
	}
}
