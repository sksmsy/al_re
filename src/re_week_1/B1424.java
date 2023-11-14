package re_week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1424 {

	static int n,l,c,result;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//곡 수 , 곡 길이  , cd용량 
		n = Integer.parseInt(br.readLine());
		l = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		
		int max = (c+1) / (l+1);
		
		int ans = Integer.MAX_VALUE;
		for (int k = max; k > 0 ; k--) {
			if(k%13 ==0) continue;
			
			
			int r = n % k;
			if(r > 0) {
				if(r % 13 == 0 && (r+1 == k || n/k ==0)) r= 2;
				else r = 1;
			}
			ans = Math.max(ans, n/k+r);
		}
		System.out.println(ans);
		
		/*
		 * 
		 *  n * l +n -1=  총길이 / c 
		 */
		
	}
}
