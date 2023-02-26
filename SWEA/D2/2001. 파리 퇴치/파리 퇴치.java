import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, N, M;
		int[][] map;
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			for(int i = 0; i < N-M+1; i++) {
				for(int j = 0; j < N-M+1; j++) {
					int sum = 0;
					for(int k = i; k <i+M; k++) {
						for(int q = j; q < j+M; q++) {
							sum += map[k][q];
						}
					}
					max = Math.max(max, sum);
				}
			}
			System.out.print("#" + tc + " ");
			System.out.println(max);
		}
	}
}