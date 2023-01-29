import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Max = -1000000;
		int Min = 1000000;
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			if(Min >= x) {
				Min = x;
			}
			if(Max <= x) {
				Max = x;
			}
		}
		System.out.println(Min + " " + Max);
		
		/*
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numArr = new int[N]; 
		for(int i = 0; i < N; i++)
			numArr[i] = sc.nextInt();
		
		int Max = 0;
		int Min = numArr[0];
		for(int i = 0; i <numArr.length; i++) {
			if(numArr[i] <= Min)
				Min = numArr[i];
			if(Max < numArr[i])
				Max = numArr[i];
		}
		System.out.println(Min + " " + Max);
		*/
	}
}
