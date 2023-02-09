

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static boolean[][] visited;
	static int[] dr = {0, 0, -1}; // 좌, 우, 상 순서
	static int[] dc = {-1, 1, 0};
	
	static int[][] board;
	static int n = 100;
	
	static int result;
	
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("src/data/sw-input1210.txt"));
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스는 무조건 10개가 주어진다. 
		
		for(int i = 0; i < 10; i++) {
			int T = sc.nextInt(); //테스트 케이스의 번호를 받아온다.
			board = new int[n][n]; //사다리가 그려질 좌표평면 선언
			visited = new boolean[n][n];
			//탐색할때 탐색한 장소를 다시 방문하지 않기 위한 방문좌표 선언
			//초기값은 false로 되어 있고 방문하면 true로 바꾸어준다.
			//이 자리에 넣어서 테스트 케이스가 바뀔 때마다 자동으로 초기화
			
			//좌표평면에 0과 1을 넣어서 사다리를 그렸다.
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					board[r][c] = sc.nextInt();
				}
			}
			
			int ans = 0;
			for(int t = 0; t < n; t++) {
				if(board[99][t] == 2)
					ans = t;
			}
			
			DFS(99, ans);
			System.out.println("#" + T + " " + result);
		}
	}
	static void DFS(int r, int c) {
		visited[r][c] = true;
		int nr, nc;
		if(r == 0) {
			result = c;
			return;
		}
		for(int i = 0; i < 3; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			
			if(0 <= nr && nr < n && 0 <= nc && nc < n) {
				if(0 < board[nr][nc] && visited[nr][nc] == false) {
					r = nr;
					c = nc;
					DFS(r, c);
					}
				}
			}
		}
	}
