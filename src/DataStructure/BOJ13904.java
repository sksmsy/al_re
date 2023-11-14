package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13904 {

	static int n,result;
	
	static class Info {
		int d,w;
		public Info(int d, int w) {
			this.d = d;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		List<Info> list = new ArrayList<>();
		
		int md = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.add(new Info(d,w));
			md = Math.max(md, d);
		}
		
		for (int i = md; i > 0; i--) {
			
		}
		
	}
}
