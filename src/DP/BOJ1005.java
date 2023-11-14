package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1005 {

	static int T,N,K,W;
	static List<Integer>[] arr;
	static int[] dp,costArr;
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken())+1;
			K = Integer.parseInt(st.nextToken());
			
			dp = new int[N];
			arr = new ArrayList[N];
			costArr = new int[N];
			
			for (int j = 0; j <N ; j++) {
				arr[j] = new ArrayList<>();
			}
			
			
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N; j++) {
				costArr[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[to].add(from);
				
			}
			W = Integer.parseInt(br.readLine());
			long res = fn(W);
			sb.append(res).append("\n");
		}

		System.out.println(sb);
		
		
	}
	
	public static long fn(int n) {
		
		if(dp[n]!= 0) {
			return dp[n];
		}
		dp[n] = costArr[n];
		long max = 0L;
		
		for (int next : arr[n]) {
			max =Math.max(fn(next), max);
		}
		
		dp[n] += max;
		return dp[n];
	}
}
