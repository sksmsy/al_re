package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ11049 {
	
	static int n, INF = Integer.MAX_VALUE;
	static int[] data;
	static int[][] dp;
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		data = new int[n+1];
		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			data[i] = s; 
			data[i+1] = e;
		}
		
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], INF);
		}
		
		System.out.println(fn(0,n-1));
	}
	
	public static int fn(int n, int cur) {
		if(n == cur) return 0;
		if(dp[n][cur] != INF) return dp[n][cur];
		
		for (int i = n; i < cur; i++) {
			int res= fn(n,i) + fn(i+1, cur) + (data[n] *data[i+1]*data[cur+1]);		
			
			dp[n][cur] = Math.min(dp[n][cur], res);
		}
 		
	
		return dp[n][cur];
	}
}
