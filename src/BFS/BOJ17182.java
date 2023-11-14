package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ17182 {

	static int n,k;
	static int dist[][];
	static boolean visit[];
	static int res = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dist = new int[n][n];
		visit = new boolean[n];
		
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(i==j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		
		visit[k] = true;
		dfs(0,k,0);
		System.out.println(res);
	}
	
	public static void dfs(int lv, int start, int sum) {
		if(lv == n-1) {
			res = Math.min(res, sum);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(lv+1,i,sum+dist[start][i]);
				visit[i] = false;
			}
		}
	}
}
