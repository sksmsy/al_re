package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16933 {
	static int n,m,k, answer, visit[][];
	
	static int arr[][];
	static int[] xx = {0,0,1,-1};
	static int[] yy = {1,-1,0,0};
	
	public static class Info{
		int x;
		int y;
		int leng;
		int b;
		boolean t;
		public Info(int x, int y, int leng, int b, boolean t) {
			this.x = x;
			this.y = y;
			this.leng = leng;
			this.b = b;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = br.read() - '0';
				visit[i][j] = k+1;
			}
			br.readLine();
		}

		
		answer = bfs();
		System.out.println(answer);
	}
	
	
	public static int bfs() {
		Queue<Info> q = new LinkedList<>();
		
		q.add(new Info(0,0,0,0,true));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			
			if(cur.x == n-1 && cur.y == m-1) {
				return cur.leng+1;
			}
			
			
			for (int i = 0; i < 4; i++) {
				int mx = cur.x + xx[i];
				int my = cur.y + yy[i];
				
				if(mx <0 || my < 0 || mx >=n || my >= m|| visit[mx][my] <= cur.b) {
					continue;
				}
				

				
				if(cur.t) {
					if(arr[mx][my] == 1) {
						if(visit[mx][my] > cur.b +1) {
							q.add(new Info(mx, my, cur.leng+1, cur.b+1, !cur.t));
							visit[mx][my] = cur.b+1;
						}
					}else {
						q.add(new Info(mx,my,cur.leng+1,cur.b,!cur.t));
						visit[mx][my] = cur.b;
					}
					
				}else {
					if(arr[mx][my] == 1) {
						q.add(new Info(cur.x, cur.y, cur.leng+1, cur.b, !cur.t));
					}else {
						q.add(new Info(mx,my,cur.leng+1,cur.b,!cur.t));
						visit[mx][my] = cur.b;	
					}
				}
				
			}
			
			
		}
		return -1;
	}
}
