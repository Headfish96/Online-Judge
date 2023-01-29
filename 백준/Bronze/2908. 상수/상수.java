import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int rA_1 = A%10; //거꾸로했을때의 100의 자리
		//System.out.println(rA_1);
		int rA_2 = (A%100)/10;
		//System.out.println(rA_2);
		int rA_3 = A/100;
		//System.out.println(rA_3);
		int rB_1 = B%10; //거꾸로했을때의 100의 자리
		int rB_2 = (B%100)/10;
		int rB_3 = B/100;
		
		int rA = rA_1 * 100 + rA_2 * 10 + rA_3;
		int rB = rB_1 * 100 + rB_2 * 10 + rB_3;
		
		if(rA > rB)
			System.out.println(rA);
		else
			System.out.println(rB);
	}
}
