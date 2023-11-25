package re_week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500 {

	static int n,m,max;
	static int arr[][];
	static boolean visit[][];
	static int mx[] = {0,0,1,-1};
	static int my[] = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit[i][j] = true;
				dfs(i,j,1,arr[i][j]);
				visit[i][j] = false;
				ff(i,j);
			}
		}
		
		System.out.println(max);
	}
	
	static void dfs(int x, int y, int cnt, int sum) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		
		for (int i = 0; i < 4; i++) {
			int xx = x+mx[i];
			int yy = y+my[i];
			
			if(xx >= n || yy >= m || xx <0 || yy<0) continue;
			
			if(!visit[xx][yy]) {
				visit[xx][yy] = true;
				dfs(xx,yy,cnt+1,sum+arr[xx][yy]);
				visit[xx][yy] = false;
			}
		}
	}
	
	static void ff(int x, int y) {
        if (x+2 < n && y+1 < m)
            max = Math.max(max, arr[x][y] + arr[x+1][y] + arr[x+1][y+1] + arr[x+2][y]);
        if (x+2 < n && y > 0)
            max = Math.max(max, arr[x][y] + arr[x+1][y] + arr[x+2][y] + arr[x+1][y-1]);
        if (x+1 < n && y+2 < m)
            max = Math.max(max, arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x+1][y+1]);
        if (x+1 < n && y+1 < m && y > 0)
            max = Math.max(max, arr[x][y] + arr[x+1][y] + arr[x+1][y-1] + arr[x+1][y+1]);
	}
}
