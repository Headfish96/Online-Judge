import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] people;
	public static void main(String[] args) throws IOException {
//		System.out.println("helloworld");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		people = new int[N][2];
		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			people[i][0] = Integer.parseInt(input[0]);
			people[i][1] = Integer.parseInt(input[1]);
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < 2; j++) {
//				System.out.print(people[i][j] + " ");
//			}
//			System.out.println();
//		}

		for(int i = 0; i < N; i++) {
			int rank = 1;
			for(int j = 0; j < N; j++) {
				if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) rank++;
			}
			System.out.print(rank + " ");
		}
	}
}