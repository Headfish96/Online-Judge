

import java.util.Scanner;

public class Main {
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; //상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1}; //팔방탐색
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if((w == 0) && (h == 0))
				break;
			map = new int[h][w];
			visited = new boolean[h][w];
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
//		for(int i = 0; i < h; i++) {
//			for(int j = 0; j < w; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
			
			
			count = 0;
			for(int row = 0; row < h; row++) {
				for(int col = 0; col < w; col++) {
					if(map[row][col] == 1 && visited[row][col] == false) {
						dfs(row, col);					
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	//좌표계를 전부 지나면서 1이 있으면 팔방 탐색을 진행한다. dfs가 1번 끝나면 이게 영역 1개 즉 섬의 개수이다.
	static void dfs(int r, int c) {
		visited[r][c] = true;
		for(int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if((nr < 0) || (nc < 0) || (nr >= h) || (nc >= w)) continue;
			if((0<=nr) && (nr<h) && (0<=nc) && (nc<w) && visited[nr][nc] == false && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
}
