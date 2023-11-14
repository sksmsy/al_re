package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17370 {

	static int n;
	
	static boolean[][] arr = new boolean[50][50];
	
	
	static int[] xx = {0,-1,1,0,-1,1};
	static int[] yy = {1,1,1,-1,-1,-1};
	
	static int[][] mv = {{2,1},{0,4},{5,0},{4,5},{1,3},{3,2}};
	static int res = 0;
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr[24][24] = true;
		System.out.println(res);
	}
	
	public static void dfs(int x, int y, int cnt, int m) {
		if(arr[y][x]) {
			if(cnt == n) {
				res++;
			}
			return;
		}
		
		if(cnt == n) return;
		
		arr[y][x] = true;
		
		for (int i = 0; i < 2; i++) {
			dfs(cnt+1, mv[m][i], x+xx[mv[m][i]],y+yy[mv[m][i]]);
		}
		arr[y][x] = false;
	}
}
