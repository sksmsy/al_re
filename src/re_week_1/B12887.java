package re_week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import BFS.BOJ1600.Info;


public class B12887 {

	static int n,cnt,minDis;
	static String arr[][];
	static int res;
	static int xx[] = {0,0,1,-1};
	static int yy[] = {1,-1,0,0};
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
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		cnt = 0;
		minDis = 0;
		
		if(n == 1) {
			res = 1;
			return;
		}
		
		arr = new String[2][n];
		
		
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
		}
		System.out.println(cnt - bfs());
		
	}
	
	public static int bfs() {
		int result = 0;
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0,0));
		
		boolean visit[][] = new boolean[2][n];
		
		
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			

			
			for (int i = 0; i < 4; i++) {
				int mx = cur.x + xx[i];
				int my = cur.y + yy[i];
				if(mx<0 || my<0 || mx>=n || my>=n || arr[mx][my] == "#" || visit[mx][my])
					continue;
				result ++;
				visit[mx][my] = true;
				q.add(new Info(mx,my));

			}
			
			

		}
		return result;
	}
}
