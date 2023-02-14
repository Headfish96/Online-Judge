

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] snacks;
	static int[] weight;
	static int N;
	static int M;
	static int R;
	static int sum;
	static int max;
	//static boolean[] selected;
	
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("src/data/sw-input9229.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			max = -1;
			N = sc.nextInt(); //과자 N개 중에
			R = 2; // 2개를 뽑는다.
			M = sc.nextInt(); //두개 무게의 최대 합이 M으로 제한
			snacks = new int[R];
			weight = new int[N];
			for(int i = 0; i < N; i++) {
				weight[i] = sc.nextInt();
			} //과자 무게의 배열에 무게를 넣는다. 과자는 N개이다.
			comb(0,0,0);
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	private static void comb(int cnt, int start, int sum) {
		if(cnt == R) {
			if(sum > M) {
				return;
			}
			if(max <= sum) {
				max = sum;
			}
			return;
		}
		for(int i = start; i < N; i++) {
			snacks[cnt] = weight[i];
			comb(cnt + 1, i + 1, sum + weight[i]);
		}
		return;
	}
}
