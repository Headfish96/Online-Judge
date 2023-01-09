import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 0;
		while (n>0) {
			a = a + n%10;
			n = n/10;
		}
		System.out.println(a);
	}

}