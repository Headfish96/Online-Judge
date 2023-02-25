

import java.util.Scanner;

public class Main {
	static int[][] apt;
	static int k;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc  = 0; tc < T; tc++) {
			k = sc.nextInt(); //k 층의
			n = sc.nextInt(); //n 호에는
			// 몇 명이 살고 있는가?
			apt = new int[k+1][n+1];
			for(int i = 1; i <= n; i++) {
				apt[0][i] = i;
			}
			
			for(int i = 1; i < k+1; i++) {
				for(int j = 1; j <= n; j++) {
					int sum = 0;
					for(int q = 1; q <= j; q++) {
						sum += apt[i-1][q];
					}
					apt[i][j] = sum;
				}
			}
			
			System.out.println(apt[k][n]);
		}
		
	}
}
