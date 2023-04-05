

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] RGB;
	static int[][] dp;
	public static void main(String[] args) {
		//System.out.println("helloworld");
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		RGB = new int[N+1][3];
		for(int i = 1; i <= N; i++) {
			RGB[i][0] = sc.nextInt();
			RGB[i][1] = sc.nextInt();
			RGB[i][2] = sc.nextInt();
		}
		
//		for(int i = 1; i <= N; i++) {
//			System.out.println(RGB[i][0] + " " + RGB[i][1] + " " + RGB[i][2]);
//		}
		
		dp = new int[N+1][3];
		dp[1][0] = RGB[1][0];
		dp[1][1] = RGB[1][1];
		dp[1][2] = RGB[1][2];
		for(int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + RGB[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + RGB[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + RGB[i][2];
		}
		int[] arr = new int[3];
		arr[0] = dp[N][0];
		arr[1] = dp[N][1];
		arr[2] = dp[N][2];
		Arrays.sort(arr);
		System.out.println(arr[0]);
	}
}
