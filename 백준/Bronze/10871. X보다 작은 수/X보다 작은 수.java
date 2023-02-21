

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//System.out.println("helloworld");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[] number = new int[N];
		for(int i = 0; i  < N; i++) {
			number[i] = sc.nextInt();
		}
		for(int i = 0; i < N; i++) {
			if(X > number[i])
				System.out.print(number[i] + " ");
		}
		
	}
}
