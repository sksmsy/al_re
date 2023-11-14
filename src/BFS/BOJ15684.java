package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15684 {

	static int n,m,h,res,arr[][];
	static boolean chk = false;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		if(m == 0) {
			System.out.println(0);
			return;
		}
		
		arr= new int[h+1][n+1];
		
		int x,y;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[x][y+1] = 2;
		}
		
		for (int i = 0; i <=3 ; i++) {
			res = i;
			dfs(1,0);
			if(chk) break;
		}
		
		
		System.out.println(chk ? res : -1);
	}
	
	public static void dfs(int x, int cnt) {
		if(chk) return;
		if(res == cnt) {
			if(check()) chk = true;
			return;
		}
		
		for (int i = x; i < h+1; i++) {
			for (int j = 1; j < n; j++) {
				if(arr[i][j] == 0 && arr[i][j+1] == 0) {
					arr[i][j] = 1;
					arr[i][j+1] = 2;
					dfs(i,cnt+1);
					
					
					//back
					arr[i][j] = arr[i][j+1] = 0;
				}
			}
		}
	}
	
	public static boolean check() {
		for (int i = 0; i <= n; i++) {
			int x = 1, y = i;
			for (int j = 0; j < h; j++) {
				if(arr[x][y] == 1) y++;
				else if(arr[x][y] == 2) y--;
				x++;
			}
			if(y!= i) return false;
		}
		return true;
	}
}
