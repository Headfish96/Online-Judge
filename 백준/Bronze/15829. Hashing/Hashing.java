

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); //문자열의 길이
		int r = 31;
		int M = 1234567891;
		
		double sum = 0;
		String word = sc.next();
		
		for(int i = 0; i < word.length(); i++) {
			sum += ((word.charAt(i) - 96) * Math.pow(31, i)%M);
		}

		System.out.println((long)sum);
	}
}