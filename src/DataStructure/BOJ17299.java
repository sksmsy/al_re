package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ17299 {

	static int n,arr[],res[];
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<Integer,Integer> map = new HashMap<>();
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		res = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		for (int i = 0; i < n; i++) {
			int num = arr[i];
			boolean chk = false;
			
			
			//이부분 스택으로 해야
			for (int j = i+1; j < n; j++) {
				int num2 = arr[j];
				
				if(map.get(num) < map.get(num2)) {
					res[i] = num2;
					chk = true;
					break;
				}
			}
			if(!chk) res[i] = -1;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(res[i] + " ");
			
		}
	}
}
