import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 1;
		int range = 1;
		
		if(num == 1) System.out.println(1);
		else {
			while(range < num) {
				range = range + 6*count;
				count++;
			}
			System.out.println(count);
		}
	}
}
