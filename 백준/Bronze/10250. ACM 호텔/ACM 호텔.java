
import java.util.Scanner;


public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 10번째 손님이면
		 * 10/H + 1가 호.
		 * 10%H가 층수.
		 */
		int T = sc.nextInt();
		int H = 0;
		int W = 0;
		int N = 0;

		for(int i = 0; i < T; i++) {
			H = sc.nextInt();
			W = sc.nextInt();
			N = sc.nextInt();
			int floor_num = 0;
			int room_num = 0;
			
			if(N%H == 0) {
				floor_num = H;
				room_num = N/H;
			}else {
				floor_num = N%H;
				room_num = N/H + 1;
			}

			System.out.println(floor_num*100 + room_num);
		}
	}
}
