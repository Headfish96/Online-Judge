import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int aws = sc.nextInt();
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(aws == arr[i]) cnt++;
		}
		System.out.println(cnt);
	}
}