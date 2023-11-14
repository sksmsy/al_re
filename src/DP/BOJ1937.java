package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1937 {

	static int[][]dp,map;
	static int n;
	static int max = 0;
	static int[] xx = {0,0,1,-1};
	static int[] yy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		dp = new int[n][n];
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int res = fn(i,j);
				max = Math.max(res, max);
			}
		}
		System.out.println(max);
	}
	
	
	public static int fn(int x, int y) {
		
		if(dp[x][y] != 0) {
			return dp[x][y];
		}
		
		dp[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int mx = xx[i] + x;
			int my = yy[i] + y;
			
			if(mx<0 || my<0 || mx>=n || my>=n || map[x][y] <= map[mx][my]) {
				continue;
			}
			dp[x][y] = Math.max(fn(mx,my)+1, dp[x][y]); 
		}
		
		
		return dp[x][y];
	}
}
