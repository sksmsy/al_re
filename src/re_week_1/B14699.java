package re_week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B14699 {
	
	static int n , m;
	static int [] h;
	static int [] dp;
	static List<Integer>[] node;
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		
		h = new int[n+1];
		node = new ArrayList[n+1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
			node[i] = new ArrayList<>();
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(h[a] < h[b]) {
				node[a].add(b);
			}else {
				node[b].add(a);
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		dp = new int[n+1];
		for (int i = 1; i <= n ; i++) {
			sb.append(fn(i)+1).append("\n");
		}
		
		System.err.println(sb);
	}
	
	public static int fn(int cur) {
		if(dp[cur] != 0) return dp[cur];
		int ans = 0;
		
		for (int next : node[cur]) {
			if(h[cur] >= h[next]) continue;
			ans = Math.max(ans, fn(next)+1);
		}
		
		return dp[cur] = ans;
	}
}
