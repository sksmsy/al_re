package re_week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12107 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(Integer.parseInt(br.readLine()) == 1 ? "B" : "A");

	}
}
