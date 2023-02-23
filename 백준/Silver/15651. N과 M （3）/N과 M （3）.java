

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int R;
	static int[] numbers;
	static int[] input;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		input = new int[N];
		numbers = new int[R];
		selected = new boolean[N];
		for(int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		perm(0);
		System.out.print(sb);
		//comb(0,0);
	}
	
	private static void perm(int cnt) {
		if(cnt == R) {
			for(int i = 0; i < R; i++) {
				sb.append(numbers[i] + " ");
				
			}
			sb.append('\n');
			return;
		}
		for(int i = 0; i < N; i++) {
			if(selected[i]) continue;
			numbers[cnt] = input[i];
			perm(cnt + 1);
		}
	
		
		
//	static void comb(int cnt, int start) {
//		if(cnt == R) {
//			for(int i = 0; i < R; i++) {
//				System.out.print(numbers[i] + " ");
//			}
//			System.out.println();
//			return;
//		}
//		for(int i = 0; i < N; i++) {
//			numbers[cnt] = input[i];
//			comb(cnt + 1, i + 1);
//		}
//		
//	}
}
}

