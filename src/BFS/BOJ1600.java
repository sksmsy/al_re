package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600 {

	
	public static class Info{
		
		int x;
		int y;
		int leng;
		int h;
		public Info(int x, int y, int leng, int h) {
			this.x = x;
			this.y = y;
			this.leng = leng;
			this.h = h;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[h][w];
		boolean visit[][][] = new boolean[k+1][h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs(w,h,arr,visit,k));	
	}
	
	
	public static int bfs(int w, int h, int arr[][],boolean visit[][][],int k) {
		Queue<Info> q = new ArrayDeque<>();
		
		q.add(new Info(0,0,0,0));
		visit[0][0][0] = true;
		int[] xx = {0,0,1,-1};
		int[] yy = {1,-1,0,0};
		int[] hx = { -2, -1, -1, -2, 1, 2, 2, 1 };
		int[] hy = { -1, -2, 2, 1, -2, -1, 1, 2 };

		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			
			if(cur.x == h-1 && cur.y == w-1) {
				return cur.leng;
			}
			
			if(cur.h < k) {
				for (int i = 0; i < 8; i++) {
					int mx = cur.x + hx[i];
					int my = cur.y + hy[i];
					int hh = cur.h + 1;
					if(mx<0 || my<0 || mx>=h || my>=w || arr[mx][my] == 1 || visit[hh][mx][my]) {
						continue;
					}
					
					visit[hh][mx][my] = true;
					q.add(new Info(mx,my,cur.leng+1,hh));
				}
			}
			
			
			for (int i = 0; i < 4; i++) {
				int mx = cur.x + xx[i];
				int my = cur.y + yy[i];
				
				if(mx<0 || my<0 || mx>=h || my>=w || arr[mx][my] == 1 || visit[cur.h][mx][my])
					continue;
				
				visit[cur.h][mx][my] = true;
				q.add(new Info(mx,my,cur.leng+1,cur.h));

			}
		}
		return -1;
	}
}
