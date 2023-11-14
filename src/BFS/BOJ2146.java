package BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146 {

	static int n,arr[][],group[][] ,cnt;
	static boolean visit[][];
	static int xx[] = {0,0,1,-1};
	static int yy[] = {1,-1,0,0};
	static Queue <Queue<Info>> q1 = new LinkedList<>();
	static Queue <Info> q2 = new LinkedList<>();
	static int min;
	
	public static class Info{
		
		int x;
		int y;
		int leng;
		int grp;
		public Info(int x, int y, int leng,int grp) {
			this.x = x;
			this.y = y;
			this.leng = leng;
			this.grp = grp;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		group = new int[n][n];
		visit = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(visit[i][j] || arr[i][j] == 0) {
					continue;
				}
				bfs(i,j);
				visit[i][j] = true;
				group[i][j] = cnt;
			}
		}
		
		bfs2();
		System.out.println(min);
		
	}
	
	public static void bfs(int x,int y) {
		Queue<Info> q = new ArrayDeque<>();
		q.add(new Info(x,y,0,0));
		cnt++;
		while(!q.isEmpty()) {
			
			Info cur = q.poll();
			
			for (int i = 0; i < 3; i++) {
				int mx = cur.x + xx[i];
				int my = cur.y + yy[i];
				
				if(mx<0 || my<0 || mx>=n || my>=n || visit[mx][my] || arr[mx][my] == 0) {
					continue;
				}
				visit[mx][my] = true;
				group[mx][my] = cnt;
				q.add(new Info(mx,my,0,cnt));
				q2.add(new Info(mx,my,0,cnt));
				
			}
		}

	}
	
	public static void bfs2() {
		Queue<Info> q = q2;
	
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for (int i = 0; i < 3; i++) {
				int mx = cur.x + xx[i];
				int my = cur.y + yy[i];
				if(mx<0 || my<0 || mx>=n || my>=n || visit[mx][my]|| arr[mx][my] == 1) {
					continue;
				}
				
				if(cur.grp != group[mx][my]) {
					min = cur.leng;
					return;
				}
				
				q.add(new Info(mx,my, cur.leng+1,cur.grp));
			}
		}
	}
}
