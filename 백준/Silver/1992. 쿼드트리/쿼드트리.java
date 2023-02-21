import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int white = 0;
	static int black = 0;
	static String[][] spaces;
	static int[][] board;
	static int count = 0;
	
	static void cut(int r, int c, int size) {
		int sum = 0;
		//int ans = 0;
		for(int i = r, rEnd = r + size; i < rEnd; i++) {
			for(int j = c, cEnd = c + size; j < cEnd; j++) {
				sum += board[i][j];
			}
		}
		if(sum == size * size) {
			System.out.print(1);
		}
		else if(sum == 0) {
			System.out.print(0);
		}else {
			int half = size / 2;
			System.out.print("(");
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
			System.out.print(")");
		}
		//System.out.print(ans);
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			String s = sc.next();
			for(int j = 0; j < N; j++) {
				board[i][j] = s.charAt(j) - 48;
			}
		}
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(board[i][j]);
//			}
//			System.out.println();
//		}
		
		cut(0,0,N);
		
	}
}
