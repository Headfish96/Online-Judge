

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		//System.out.println("helloworld");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = 666;
		int count = 1;
		
		while(count != N) {
			num++;
			if(String.valueOf(num).contains("666")) {
				count++;
			}
		}
		System.out.println(num);
		
	}
}
