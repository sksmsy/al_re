package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1516 {

	static int n;
	static int[] in,cost;
	static List<Integer>[] arr;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine())+1;
		
		arr = new ArrayList[n];
		in = new int[n];
		cost = new int[n];
		
		for (int i = 1; i < n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		
		
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			cost[i] = s;
			
			while(st.hasMoreTokens()) {
				int e = Integer.parseInt(st.nextToken());
				
				if(e == -1)break;
				in[i]++;
				arr[e].add(i);
			}
			
		}
		
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[n];
		
		
		for (int i = 1; i < n; i++) {
			if(in[i] == 0) {
				q.offer(i);
			}
			result[i] = cost[i];
		}
		while(!q.isEmpty()) {
			int idx = q.poll();
			
			for (int i : arr[idx]) {
				result[i] = Math.max(result[i], result[idx]+cost[i]);
				
				if(--in[i] == 0) {
					q.offer(i);
				}
				
			}
			
			
		}
		
		for (int i = 1; i < n; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
		
		
	}
	
}
