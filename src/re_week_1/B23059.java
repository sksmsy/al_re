package re_week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B23059 {

	static int n;
	static Map<String, String> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			map.put(st.nextToken(), st.nextToken());
		}
		System.out.println(map);
	}
}
