
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/data/sw-input2001.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 수를 입력받는다.
		
		for(int k = 1; k <= T; k++) {
			int N = sc.nextInt(); // 파리가 있는 N*N의 영역 생성
			int M = sc.nextInt(); // 파리채의 크기 M*M의 영역 생성
			int board[][] = new int[N][N];
			int flapper[][] = new int[M][M];
			
			//배열값 받아오기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			/*
			// 배열이 잘 만들어졌나 출력해보기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(board[i][j] + " ");
				}System.out.println();
			}
			System.out.println();
			*/
			
			int F = (N-M) + 1;
			//int sum = 0;
			//int max = 0;
			/*
			for(int r = 0; r < F; r++) {
				for(int c = 0; c < F; c++) {
					for(int h = r; h < r+M; h++) {
						for(int q = c; q < c+M; q++) {
							sum += board[h][q];
						}
					}
					System.out.println(sum);
				}
					
			}
			*/
			
			//F의 영역
			/*
			for(int r = 0; r < F; r++) {
				for(int c = 0; c < F; c++) {
					System.out.print("[" + r + "][" + c + "] ");
				}
				System.out.println();
			}
			System.out.println();
			*/
			
			//M의 영역
			/*
			for(int r = 0; r < F; r++) {
				for(int c = 0; c < F; c++) {
					for(int h = r; h < r+M; h++) {
						for(int q = c; q < c+M; q++) {
							System.out.print("[" + h + "][" + q + "] ");
						}
						System.out.println();
					}
					System.out.println();
				}
					
			}
			*/
			
			
			
			
			//M의 영역의 합
			int max = 0;
			for(int r = 0; r < F; r++) {
				for(int c = 0; c < F; c++) {
					int sum = 0;
					for(int h = r; h < r+M; h++) {
						for(int q = c; q < c+M; q++) {
							//System.out.print("[" + h + "][" + q + "] ");
							sum += board[h][q];
						}
						//System.out.println();
					}
					if(max <= sum)
						max = sum;
					//System.out.print("sum = "+ sum + " max = "+ max);
					//System.out.println();
				}
				//System.out.println(max);
				
			}
			System.out.println("#" + k + " " + max);
			
			
			
			
			
			
		}
	}
}

/*
 * m이 정해지면 만들 수 있는 파리채의 개수는 (N-M)+1)^2
 * m이 만들어지는 기준을 왼쪽 위라고 했을때, 그 기준점은 N*N의 평면 위에서
 * 0,0 부터 시작해서 크기가  (N-M)+1)^2 인 평면을 돌아다닐 수 있다.
 * 예를 들어 N = 4, M = 3이라면
 * (N-M)+1 = 2 이므로 파리채는 4개가 만들어지고 그 파리채가 만들어지는 시작점은
 * (0,0),(0,1)
 * (1,0),(1,1)
 * 의 좌표를 순차적으로 돌게된다.
 * N-M+1 을 F라고 정하면
 * M과 M의 값이 정해질때마다 F가 정해지고
 * F = N- M + 1;
 * 이 F를 통해 M에 적용될 시작 좌표를 구할 수 있다.
 * for(int r = 0; r < F; r++){
 * 	for(int c = 0; c < F; c++){
 * 		for(int k = r; k < r+M; k++){
 *			for(int q = c; q < c+M; q++){
 *				sum += board[k,q]
 *			}
 * 		}
 * 	}
 * }
 * 	
 * 		
 * 			
 * F가 좌표평면을 돌때마다 M에 속해있는 파리들(점들, 집합들)이 구해진다.
 * 예를 들어 위 예시에서 F가 (0,0)일때
 * M = board[0][0] + board[0][1] + board[0][2]
 * + board[1][0] + board[1][1] + board[1][2]
 * + board[2][0] + board[2][1] + board[2][2];
 * 이 된다.
 * 즉, F의 좌표를 (r,c)라고 하면 이때 M은
 * for(int i = r; i < r+M; i++)
 * 	for(int j = c; j < c+M; j++)
 * 		sum = sum + board[i][j];
 */