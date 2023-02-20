

import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] input, numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		input = new int[N];
		
		for(int i = 1; i <= N; i++) {
			input[i-1] = i;
		}
		
		comb(0, 0);
	}
	public static void comb(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);			
		}
	}
}
