import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][2];
		for(int i = 0; i < N; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
		}
//		System.out.println();
//		for(int i = 0; i < N; i++) {
//			System.out.println(map[i][0] + " " + map[i][1]);
//		}
		
		Arrays.sort(map, (e1, e2) -> {
			if(e1[1] == e2[1]) {
				return e1[0] - e2[0];
			} else {
				return e1[1] - e2[1];
			}
		});
		
		for(int i = 0; i < N; i++) {
			System.out.println(map[i][0] + " " + map[i][1]);
		}
		
	}
}