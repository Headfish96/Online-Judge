import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static int[] inputs, numbers;
	static int N; //N개의 숫자 중
	static int M;
	static int[] max;
	static ArrayList<Integer> maxSum;
	public static void main(String[] args) {
		maxSum = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		inputs = new int[N];
		numbers = new int[3];
		
		for(int i = 0; i < N; i++)
			inputs[i] = sc.nextInt();
		
		comb(0,0);
		
		int max = 0;
		for(int i = 0; i < maxSum.size(); i++) {
			if(max <= maxSum.get(i))
				max = maxSum.get(i);
		}
		System.out.println(max);

	}
	private static void comb(int cnt, int start) {
		 
		if(cnt == 3) {
			int sum = 0;
			for(int i = 0; i < 3; i++)
				sum += numbers[i];
			if(sum <= M)
				maxSum.add(sum);
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt +1, i+1);
		}
	}
}
