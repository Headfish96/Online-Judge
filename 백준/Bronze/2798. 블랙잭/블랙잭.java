import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int R;
	static int M;
	static int[] input;
	static int[] numbers;
	static int cnt;
	static int sum;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		//R = sc.nextInt();
		R = 3;
		input = new int[N];
		numbers = new int[R];
		max = 0;
		
		for(int i = 0; i < N; i++) input[i] = sc.nextInt();
		
		comb(0,0);
		System.out.println(max);
	}
	private static void comb(int cnt, int start) {
		// TODO Auto-generated method stub
		if(cnt == R) {
			sum = 0;
			for(int i = 0; i < 3; i++) {
				sum = sum + numbers[i];
			}
			if(sum > M) return;
			max = Math.max(sum, max);
			//System.out.print(Arrays.toString(numbers));
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i  + 1);
		}
	}
	
}
