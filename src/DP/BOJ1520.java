package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520 {
	
	static int[][] dp,arr;
	static int m,n,res;
	static int[] xx = {0,0,1,-1};
	static int[] yy = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		dp = new int[m][n];
		arr = new int[m][n];
		
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		dp[0][0] = 1;
		res = fn(m-1,n-1);
		System.out.println(res);
	}
	
	public static int fn(int x, int y) {
		
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		
		for (int i = 0; i < 4; i++) {
			int mx = xx[i]+x;
			int my = yy[i]+y;
			
			
			if(mx<0 || my<0 || mx>=m || my>=n || arr[x][y] >= arr[mx][my]) {
				continue;
			}
			
			
			dp[x][y] += fn(mx,my);
		}
		
		return dp[x][y];
	}
}
