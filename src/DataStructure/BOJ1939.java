package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ1939 {

	
	static int n,m,fac1,fac2;
	static Info[] arr;
	public static class Info{
		int to;
		int w;
		public Info(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new Info[n];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			
			arr[s] = new Info(to,wei);
			arr[to] = new Info(s,wei);
		}
		st = new StringTokenizer(br.readLine());
		fac1 = Integer.parseInt(st.nextToken());
		fac2 = Integer.parseInt(st.nextToken());
		
	}
}
