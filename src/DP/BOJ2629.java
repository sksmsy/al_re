package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2629 {

	static int wCnt,bCnt,max=15000;
	static int[] arr;
	static boolean[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		wCnt = Integer.parseInt(br.readLine());
		arr = new int[wCnt+1];
		dp = new boolean[31][max+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= wCnt; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		fn(0,0);
		
		bCnt = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < bCnt; i++) {
			int q = Integer.parseInt(st.nextToken());
			if(q > 15000)sb.append("N ");
			else sb.append(dp[wCnt][q]?"Y " : "N ");
		}
		System.out.println(sb);
	}
	
	
	public static void fn(int idx, int weight) {
		if(dp[idx][weight]) return;
		dp[idx][weight] = true;
		if(idx == wCnt) return;
		
		fn(idx+1, weight+arr[idx+1]);
		fn(idx+1, weight);
		fn(idx+1, Math.abs(weight-arr[idx+1]));
		
	}
}
