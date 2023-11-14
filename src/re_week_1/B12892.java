package re_week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12892 {

	
	static int n,d;
	static Pre[] pre;
	static long ans;
	
	static class Pre implements Comparable<Pre>{
		int p,v;
		
		Pre(int p , int v){
			this.p = p;
			this.v = v;
		}
		
		@Override
		public int compareTo(Pre o) {
			return Integer.compare(this.p, o.p);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			pre[i] = new Pre(p,v);
		}
		
		Arrays.sort(pre);
		
		long sum = 0;
		int s = 0;
		int e = 0;
		ans = sum;
		
		while(true) {
			while(e < n && pre[e].p - pre[s].p < d) {
				sum += pre[e].v;
				e++;
			}
			
			ans = Math.max(ans, sum);
			if(e == n) break;
			
			sum -= pre[s].v;
			s++;
		}
		
		System.out.println(ans);
		
	}
}
