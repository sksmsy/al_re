package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638 {

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
		
		int n,m,arr[][];
		boolean visit[][];
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    arr[i][j]++;
                }
            }
        }

		
		Queue<Info> q = new ArrayDeque<>();
		q.add(new Info(0,0));
		visit[0][0] = true;
		int t = 0;
		while(!q.isEmpty()) {
			System.out.println(t+"t =======================================");
			q = bfs(q, visit, n, m, arr);
			t++;
		}
		
		System.out.println(t-1);
	}
	
	
	public static Queue<Info> bfs(Queue<Info> q , boolean[][] visit, int n, int m, int[][]arr) {
		int[] xx = {0,0,1,-1};
		int[] yy = {1,-1,0,0};
		
		Queue<Info> next = new ArrayDeque<>();
		
		while(!q.isEmpty()) {
			Info cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int mx = cur.x + xx[i];
				int my = cur.y + yy[i];
				
				
				if(mx<0 || my<0 || mx>=n || my>=m || visit[mx][my]) {
					continue;
				}
			
				
				if(arr[mx][my] > 0) {
					if(--arr[mx][my] == 0) {
						visit[mx][my] = true;
						next.add(new Info(mx,my));
					}
				}else {
					visit[mx][my] = true;
					q.add(new Info(mx,my));
				}
				
				for (int k = 0; k < n; k++) {
					for (int j = 0; j < m; j++) {
						System.out.print(arr[k][j] + " ");
					}
					System.out.println();
				}
				
				System.out.println();
				System.out.println("------------------------------");
				System.out.println();
			}
			
			
		}
		return next;
	}
}
