

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] inputs, numbers;
	//static int[][] sum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		inputs = new int[9];
		//뽑을 대상인 N은 9, 뽑히는 대상의 개수인 R은 7
		numbers = new int[7];
		for(int i = 0; i < 9; i++) {
			inputs[i] = sc.nextInt();
		}
		
		comb(0,0);
		
	}
	private static void comb(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			//System.out.println(Arrays.toString(numbers));
			for(int i = 0; i < 7; i++) {
				sum += numbers[i];
			}
			//System.out.println(sum);
			if (sum == 100) {
				for(int i = 0; i < 7; i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt + 1, i + 1);
		}
	}
}
