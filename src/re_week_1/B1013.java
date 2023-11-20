package re_week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1013 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String pt = "(100+1+|01)+";
		
		int t = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			if(str.matches(pt)) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.println(sb);
	}
}
