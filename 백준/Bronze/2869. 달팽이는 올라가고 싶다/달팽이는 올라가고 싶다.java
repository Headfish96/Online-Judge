

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bw.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken()); //자는 동안 내려가는 거리
		int V = Integer.parseInt(st.nextToken()); //나무 막대 길이
		if((V - A)%(A-B) == 0) {
			System.out.println((V- A)/(A-B) + 1);
		}else
			System.out.println((V- A)/(A-B) + 2);
	}
}
