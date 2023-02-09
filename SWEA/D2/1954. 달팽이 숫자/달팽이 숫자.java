

import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] board;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int k = 1; k <= t; k++) {
			
			N = sc.nextInt();
			board = new int[N][N];
			DFS(0, 0, 0, 0);
			System.out.println("#"+k);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static void DFS(int r, int c, int v, int x) {
		if(x == N*N)
			return;
		if( (r+dr[v] < 0) || (c+dc[v] < 0) || (r+dr[v] >= N) || (c+dc[v] >= N)
				|| (board[r+dr[v]][c+dc[v]] != 0)) {
			v = (v+1)%4;
		}
		x++;
		board[r][c] = x;
		r = r + dr[v];
		c = c + dc[v];
		DFS(r,c,v,x);
	}
}
