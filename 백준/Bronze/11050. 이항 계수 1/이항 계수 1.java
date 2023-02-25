

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int R;
	static int[] numbers;
	static int[] input;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		//numbers = new int[R];
		//input = new int[N];
		//for (int i = 0; i < N; i++) input[i] = sc.nextInt();
		comb(0,0);
		System.out.println(count);
	}
	static void comb(int cnt, int start) {
		if(cnt == R) {
			++count;
			//System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = start; i < N; i++) {
			//numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
}
