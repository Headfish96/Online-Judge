
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int blank_num = 0;
		int star_num = 0;

		for(int i = 1; i <= N ; i++) {
			star_num = 2*i - 1;
			blank_num = N - i;
			for(int j = 1; j <= blank_num; j++)
				System.out.print(" ");
			for(int j = 1; j <= star_num; j++)
				System.out.print("*");
			System.out.println();
		}
		for(int i = 1; i<=N-1; i++) {
			blank_num = i;
			star_num = 2*(N-i) - 1;
			for(int j = 1; j <= blank_num; j++)
					System.out.print(" ");
			for(int j = 1; j <= star_num; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
