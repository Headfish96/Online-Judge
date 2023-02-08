

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	static int N, M;
	static int[] numbers;
	static int[] inputs;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inputs = new int[N];
		for(int i = 1; i <= N; i++) {
			inputs[i-1] = i; // 0에는 아무것도 없다. 인덱스 1부터 N까지 1부터 N이 들어가있다.
		}
		M = sc.nextInt();
		numbers = new int[M]; //M개의 숫자를 뽑아서 넣을 배열 numbers를 선언한다.
		 //1부터 N까지의 자연수 중에 중복 없이 M개를 고른 수열
		visited = new boolean[N];
		perm(0);
		
		//comb(0,0);
		
	}
	
	/*
	private static void comb(int cnt, int start) {
		if(cnt == M) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt + 1, i+1);
		}
	}
	*/
	
	private static void perm(int cnt) {
		if (cnt == M) { //뽑은 개수가 M개이면 멈추고 출력
			//System.out.println(Arrays.toString(numbers));
			for(int i = 0; i < cnt; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue; //만약 방문한 숫자면 그 다음 숫자로 넘어간다.
			
			visited[i] = true;
			numbers[cnt] = inputs[i];
			perm(cnt+1);
			visited[i] = false;
		}
	}
	
}
