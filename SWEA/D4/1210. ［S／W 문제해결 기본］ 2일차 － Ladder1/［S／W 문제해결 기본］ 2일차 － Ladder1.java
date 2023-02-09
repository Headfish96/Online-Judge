

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	//사다리가 내려갈때 한번 방문한 곳은 다시 방문하지 않기 위해 visited배
	static boolean[][] visited;
	
	// 좌 -> 우 -> 하 순서로 탐
	static int[] dr = {0,0,1};
	static int[] dc = {-1,1,0};
	
	//사다리가 그려질 영역 board 선언
	static int[][] board;
	
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("src/data/sw-input1210.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 0; t < 10; t++) { //테스트 케이스는 총 10
			int tc = sc.nextInt(); // 테스트 케이스의 번호를 읽어온다.
			board = new int[100][100]; //사다리가 그려질 영역은 초기화
			visited = new boolean[100][100];
			
			//사다리 입력받는다.
			for(int r = 0; r < 100; r++) {
				for(int c = 0; c < 100; c++) {
					board[r][c] = sc.nextInt();
				}
			}
			
			int ans = 0; //출발지의 c값이 저장될 ans 변수 선언
			
			//첫번째 행에 값이 1인 열이 있다면 해당 행,열 좌표에서 사다리 시작
			for(int i = 0; i < 100; i++) {
				if(board[0][i]==1) {
					Reset(visited); //초기화 안해주면 중간에 막혀서 내려갈 수 없음.
					DFS(0,i);
					if(result > 0) {
						ans = i;
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	static void Reset(boolean[][] b) {
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				b[i][j] = false;
			}
		}
	}
	
	static int result;
	static void DFS(int r, int c) {
		visited[r][c] = true; //DFS가 시작되었다는 것은 방문한 것이니 true로 바꿔준다.
		int nr, nc;
		
		//사다리 끝까지 내려갔고 도착지 좌표의 값이 2을 가지면
		//result에 c의 값, 즉 몇번째 열인지 열 좌표를 저장한다.
		if( r == 99 && board[r][c] == 2) {
			result = 1;
			return;	
		}
		else if(r == 99 && board[r][c]==1) { // 사다리가 끝까지 내려갔는데 도착지의 값이 1이라면
			result = -1; // result에 -1을 넣어준다.
			return;	 // 끝까지 갔는데 2가 아닌 경우에도 리턴을 해야한다.
		}
		
		
		for(int i = 0; i < 3; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if((0 <= nr) && (nr < 100) && (0 <= nc) && (nc < 100)) {
				if((board[nr][nc] > 0) && (visited[nr][nc] == false)) {
					r = nr;
					c = nc;
					DFS(r, c);
				}
			}
		}
	}
	
	
}
