package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 
 * 매우 중요 
 * 벽 부수기 로직 
 * 
 * 83 line *******
 * 
 */
public class BOJ2206 {

	static int n,m;
	static String [][]arr;
	static int visit[][];
	static int xx[] = {0,0,1,-1};
	static int yy[] = {1,-1,0,0};
	static int answer = 0;
	public static class Node{
		int x;
		int y;
		int leng;
		int b;
		
		
		public Node(int x, int y,int leng, int b) {
			this.x =x;
			this.y =y;
			this.leng = leng;
			this.b = b;
			

		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new String[n][m];
		visit = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				arr[i][j] = tmp[j]+"";
				visit[i][j] = 2;
			}
		}
		
		answer = bfs();
		System.out.println(answer);
	}
	
	public static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,0,0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.x == n-1 && cur.y == m-1) {
				answer = cur.leng+1;
				return answer;
			}
			
			
			for (int i = 0; i < 4; i++) {
				int mx = cur.x + xx[i];
				int my = cur.y + yy[i];
				
				if(mx>=0 && mx<n && my>= 0 && my < m && visit[mx][my] > cur.b) {
					if(arr[mx][my].equals("1")) {
						if(cur.b == 0) {
							q.add(new Node(mx,my,cur.leng+1,1));
							visit[mx][my] = 1;
						}
					}else {
						q.add(new Node(mx,my,cur.leng+1,cur.b));
						visit[mx][my] = cur.b;
					}
				}

			}
			
			

		}
		return -1;
	}
}
