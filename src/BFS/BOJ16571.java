package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16571 {

	static int[][] arr = new int[3][3];
	static boolean[][] visit = new boolean[3][3];
	static int cnt,min,turn;
	static String win;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int f = 0;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0) {
					f++;
				}
			}
		}
		cnt = f;
		turn = f/2 == 0 ? 2 : 1;
		
		

		dfs(cnt);

		System.out.println(min);
	}
	
	public static void dfs(int cnt) {

		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = turn;
					if(chk(cnt)) {
						min = Math.min(min, -1);
					}
					
					min=Math.min(min, chk(1));
				}
			}
		}
		
		
		
	}
	
	public static boolean chk(int cur) {
		
		for (int i = 0; i < 3; i++) {
			if ((arr[i][0] == 1 && arr[i][1] == 1 && arr[i][2] == 1)||
					(arr[0][i] == 1 && arr[1][i] == 1 && arr[2][i] == 1)||
					(arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1)||
					(arr[2][0] == 1 && arr[1][1] == 1 && arr[0][2] == 1)) {
				return true;
			}
			if ((arr[i][0] == 2 && arr[i][1] == 2 && arr[i][2] == 2)||
					(arr[0][i] == 2 && arr[1][i] == 2 && arr[2][i] == 2)||
					(arr[0][0] == 2 && arr[1][1] == 2 && arr[2][2] == 2)||
					(arr[2][0] == 2 && arr[1][1] == 2 && arr[0][2] == 2)) {
				return true;
			}
		}

		return false;
	}
}
