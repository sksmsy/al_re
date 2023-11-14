package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7579 {

	
	static int N,M,res;
	static int[] arr,arr2,dp;
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		arr2 = new int[N];
		dp = new int[10001];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp, -1);
		
		for (int i = 0; i < N; i++) {
			int cost = arr2[i];
			
			for (int j = 10000; j >=cost; j--) {
				if(dp[j-cost] != -1) {
					if(dp[j-cost] + arr[i] > dp[j]) {
						dp[j] = dp[j-cost] + arr[i];
					}
				}
			}
			
			if(dp[cost] < arr[i]) dp[cost] = arr[i];
		}
		
		for (int i = 0; i < 10001; i++) {
			if(dp[i]>=M) {
				System.out.println(i);
				break;
			}
		}
		
	}

}


//https://hoho325.tistory.com/165
