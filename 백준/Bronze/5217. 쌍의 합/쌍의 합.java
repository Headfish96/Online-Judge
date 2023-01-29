
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int j = 0; j < T; j++) {
			int N = sc.nextInt();
			System.out.print("Pairs for " + N + ": ");
			if(N%2 == 0) { //N이 짝수일 경우
				for(int i = 1; i < N/2; i++ ) {
					int x = i;
					int y = N - i;
					if(i == 1)
						System.out.print(x + " " + y );
					else
						System.out.print(", " + x + " " + y);
					
				}
				System.out.println();
			}else if(N%2 != 0) {
				for(int i = 1; i <= N/2; i++ ) {
					int x = i;
					int y = N - i;
					if(i == 1)
						System.out.print(x + " " + y);
					else
						System.out.print(", " + x + " " + y );
				}
				System.out.println();
			}
		}
	}
}
