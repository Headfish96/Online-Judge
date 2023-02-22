

import java.util.Scanner;

public class Main {
	private static int pow(int n) {
		if(n==1) return 2;
		int y = pow(n/2);
		return n%2 == 0? y*y : y*y*2;}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); //문자열의 길이
		int r = 31;
		int M = 1234567891;
		
		long[] number = new long[L];
		long sum = 0;
		String word = sc.next();
		for(int i = 0; i < L; i++) {
			number[i] = word.charAt(i) - 96;
		}
		
//		for(int i = 0; i < L; i++) {
//			sum += (number[i]%M) * Math.pow(r%M, i)%M;
//		}
		long pow = 1;
		for(int i = 0; i < L; i++) {
			sum += (number[i]%M) * pow % M;
			pow = pow%M * r%M;
		}
		
		System.out.println(sum);
		/*
		 * ((number[0] * Math.pow(31,0)) + (number[1] * Math.pow(31,1)) + (number[2] * Math.pow(31,2)) + (number[3] * Math.pow(31,3)) + (number[4] * Math.pow(31,4))) % M
		 * ((number[0] * Math.pow(31,0))%M + (number[1] * Math.pow(31,1))%M + (number[2] * Math.pow(31,2))%M + (number[3] * Math.pow(31,3))%M + (number[4] * Math.pow(31,4))%M)
		 * ((number[0]%M * Math.pow(31,0)%M) + (number[1]%M * Math.pow(31,1)%M) + (number[2]%M * Math.pow(31,2)%M) + (number[3]%M * Math.pow(31,3)%M) + (number[4]%M * Math.pow(31,4)%M))
		 * 
		 */
	}
}