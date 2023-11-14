package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14442 {

	static int n,m,k,visit[][], answer;
	static String arr[][];
	static int[] xx = {0,0,1,-1};
	static int[] yy = {1,-1,0,0};
	
	public static class Info{
		int x;
		int y;
		int leng;
		int b;
		
		public Info(int x, int y, int leng, int b) {
			this.x = x;
			this.y = y;
			this.leng = leng;
			this.b = b;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		visit = new int[n][m];
		arr = new String[n][m];
		
		
		for (int i = 0; i < n; i++) {
			char tmp[] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				arr[i][j] = tmp[j]+"";
				visit[i][j] = k+1;
			}
		}
		
		answer = bfs();
		System.out.println(answer);
	}
	
	public static int bfs() {
		
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0,0,0,0));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			
			if(cur.x == n-1 && cur.y == m-1) {
				
				return cur.leng+1; 
			}
			
			for (int i = 0; i < 4; i++) {
				int mx = cur.x + xx[i];
				int my = cur.y + yy[i];
				
				if(mx >=0 && mx < n && my >= 0 && my < m && visit[mx][my] > cur.b) {
					if(arr[mx][my].equals("1")) {
						if(cur.b < k+1) {
							q.add(new Info(mx,my,cur.leng+1, cur.b+1));
							visit[mx][my]--;
						}
					}else {
						q.add(new Info(mx,my,cur.leng+1,cur.b));
						visit[mx][my] = cur.b;
					}
				}
			}
			
		}
		
		return -1;
	}
}
