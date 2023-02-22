

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//System.out.println("helloworld");
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); //문자열의 길이
		int r = 31;
		int M = 1234567891;
		
		int sum = 0;
		String word = sc.next();
		int[] number = new int[word.length()];
		for(int i = 0; i < number.length; i++) {
			number[i] = (int)word.charAt(i) - 96;
		}		
		
//		for(int i = 0; i < number.length; i++) {
//			number[i] = number[i] * Math.pow(31, number[i]);
//		}
//		for(int i = 0; i < number.length; i++) {
//			sum = sum + number[i];
//		}
//		System.out.println(sum);
		
//		for(int i = 0; i < number.length; i++) {
//			System.out.println(number[i]);
//		}
		
//		System.out.println(number[0] + 2);
		//System.out.println(Math.pow(31, number[0]));
		//System.out.println(Math.pow(31, number[1]));
		
		for(int i = 0; i <word.length(); i++) {
			sum = sum + number[i] * (int)Math.pow(31, i);
		}
		System.out.println(sum);
		
//		String word = sc.next();
//		System.out.println();
//		
//		char[] c = new char[word.length()];
//		int[] number = new int[word.length()];
//		for(int i = 0; i < c.length; i++) {
//			c[i] = word.charAt(i);
//		}
//		
//		for(int i = 0; i < number.length; i++) {
//			number[i] = (int)word.charAt(i);
//		}
//		for(int i = 0; i < number.length; i++) {
//			System.out.println(number[i]);
//		}
	}
}
