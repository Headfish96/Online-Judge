import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][] scaf;
	static int N;
	static int[] dr;
	static int[] dc;
	public static void main(String[] args) {
		//System.out.println("helloworld");
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //검은 스카프의 수
		scaf = new int[N][2]; //스카프의 왼쪽 아래 꼭짓점의 좌표가 들어가는 이차원 배열
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				scaf[i][j] = sc.nextInt(); //스카프의 위치 정보를 입력
			}
		}

		map = new int[100][100];
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				map[i][j] = 0; //스카프가 덮을 천을 선언하고 0으로 초기화
			}
		}

		for(int i = 0; i < N; i++) {
			for(int r = scaf[i][0]; r < scaf[i][0] + 10; r++) {
				for(int c = scaf[i][1]; c <  scaf[i][1] + 10; c++) {
					map[r][c] = 1; //스카프가 덮은 곳은 1로 만들어준다.
				}
			}
		}
		
		dr = new int[] {-1, 1, 0, 0};
		dc = new int[] {0, 0, -1, 1}; //상하좌우 사방탐색
		int count = 0;
		
		for(int r = 0; r < 100; r++) {
			for(int c = 0; c < 100; c++) {
				if(map[r][c] == 1) {
					for(int i = 0; i < 4; i++) {
						// 각 칸에서 사방탐색해서 범위를 벗어나거나 0이라서 덮히지 않은 부분이면 count를 늘려준다. 
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(nr < 0 || nr >= 100 || nc < 0 || nc >= 100) {
							count ++;
						}
						else if(map[nr][nc] == 0) count++;
					}
				}
				
			}
		}
		System.out.println(count);
		
		
	}
}
