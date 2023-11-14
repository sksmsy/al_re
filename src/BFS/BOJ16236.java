package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236 {

	
	static int n,arr[][];
	static boolean visit[][];
	
	public static class Info{
		int x;
		int y;
		int leng;
		
		public Info(int x, int y, int leng) {
			this.x = x;
			this.y = y;
			this.leng = leng;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visit = new boolean[n][n];
		
		int start[] = new int[2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		
	}
	
	public static void bfs() {
		Queue<Info> q = new LinkedList<>();
		
	}
}
