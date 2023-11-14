package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16946 {

	static int n,m,arr[][],arr2[][];
	static int[] xx = {0,0,1,-1};
	static int[] yy = {1,-1,0,0};
	
	public static class Info{
		
		int x;
		int y;
		
		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = br.read()-'0';
			}
			br.readLine();
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] == 1) {
					sb.append(bfs(i,j));
				}
			}
		}
		
	}
	
	public static int bfs(int x, int y) {
		Queue<Info > q = new LinkedList<>();
		q.add(new Info(x, y));
		boolean visit[][] = new boolean[n][m];
		int cnt = 1;
		while(!q.isEmpty()) {
			
			Info cur = q.poll();
			
			
			for (int i = 0; i < 4; i++) {
				int mx = cur.x + xx[i];
				int my = cur.y + yy[i];
				
				if(mx<0 || my<0 || mx>=n || my>=m || visit[mx][my] || arr[mx][my] ==1) {
					continue;
				}
				visit[mx][my] = true;
				
				q.add(new Info(mx,my));
				cnt++;
			}
		}
		return cnt%10;
	}
}
