import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] board;
	public static void main(String[] args) {
//		System.out.println("hello");
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		String[] arr = new String[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
//		for(int i = 0; i < N; i++) {
//			System.out.println(arr[i]);
//		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i].charAt(j) == 'W') {
					board[i][j] = 1;
				}
				else {
					board[i][j] = 0;
				}
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(board[i][j]);
//			}
//			System.out.println();
//		}
		/*
		 * 하얀색이 1, 검정색이 0
		 */
		/*
		 * 세로가 N이고 가로가 M인 판이 있는 것
		 * 크기가 8씩으로 자르면 세로에서는 N - 8 + 1 개 가로에서도 M - 8 + 1개
		 * 따라서 8*8 크기로 자를 수 있는 총 개수는 (N-8+1)*(M-8+1)개
		 * 그리고 한번 잘랐으면 다시 색칠해야 하는 경우는 두가지이다. 왼쪽 위를 하얀색으로 할 경우와 검정색으로 할 경우.
		 * 따라서 자른 것과 왼쪽 위가 하얀색으로 칠한 체스판과 비교하고, 자른 것과 왼쪽 위가 검정색으로 칠해져있는 체스판을 비교해서
		 * 같은게 더 많은, 다른게 더 적은 방향으로 칠하면 된다.
		 * 그리고 이 경우를 더 적은게 나오면 바꾸는 것으로 최신화하면 된다.
		 * 
		 */
		int[][] chess = new int[N-8+1][M-8+1];
		int[][] whiteBoard = new int[8][8];
		int[][] blackBoard = new int[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if((i+j)%2 == 0) {
					whiteBoard[i][j] = 1;
					blackBoard[i][j] = 0;
				}
				else if((i+j)%2 != 0){
					whiteBoard[i][j] = 0;
					blackBoard[i][j] = 1;
				}
			}
		}
//		System.out.println("왼쪽 위가 1로 하얀색으로 시작하는 체스");
//		for(int i = 0; i < 8; i++) {
//			for(int j = 0; j < 8; j++) {
//				System.out.print(whiteBoard[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("왼쪽 위가 0으로 검정색으로 시작하는 체스");
//		for(int i = 0; i < 8; i++) {
//			for(int j = 0; j < 8; j++) {
//				System.out.print(blackBoard[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N-8+1; i++) {
			for(int j = 0; j < M-8+1; j++) {
				//System.out.print("i = " + i + " j = " + j);
				//System.out.println();
				int whiteCnt = 0;
				int blackCnt = 0;
				for(int k = i; k < i + 8; k++) {
					for(int q = j; q < j+8; q++) {
						//System.out.print(board[k][q] + " ");
						//System.out.println(whiteBoard[k-i][q-j]);
						if(board[k][q] != whiteBoard[k-i][q-j]) {
							whiteCnt++;
						}
						if(board[k][q] != blackBoard[k-i][q-j]) {
							blackCnt++;
						}
						
					}
					//System.out.println();
				}
				min = Math.min(min, Math.min(blackCnt, whiteCnt));
			}
			//System.out.println();
		}
		System.out.println(min);
		
		
	}
}