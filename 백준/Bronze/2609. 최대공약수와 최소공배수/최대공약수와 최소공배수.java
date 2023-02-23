
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arrN = new int[N];
		int M = sc.nextInt();
		int[] arrM = new int[M];
		int countN = 0;
		int countM = 0;
		int max = 0;
		for(int i = 1; i <= N; i++) {
			if((N%i) == 0) {
				arrN[countN] = i;
				countN++;
			}
		}
//		for(int i = 0; i < countN; i++) {
//			System.out.println(arrN[i]);
//		}
		for(int i = 1; i <= M; i++) {
			if((M%i) == 0) {
				arrM[countM] = i;
				countM++;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arrN[i] == arrM[j]) {
					max = Math.max(max, arrN[i]);
				}
			}
		}
		
		System.out.println(max);
		
		int maxx = N*M/max;
		
		System.out.println(maxx);
	}
}
