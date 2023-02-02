
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			int M = i;
			int sum = 0;
			while(M != 0) {
				sum += M%10;
				M = M/10;
			}
			
			if(sum + i == N) {
				System.out.println(i);
				break;
			}
			
			if((sum + i != N) && (i == N)) {
				System.out.println("0");
			}
		}
	}
}

