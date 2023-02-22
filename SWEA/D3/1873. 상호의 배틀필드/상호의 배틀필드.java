

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int r; // 탱크의 현재 행 위치
	static int c; // 탱크의 현재 열 위치
	static char tank; // 탱크의 방향
	static char[][] battlefiled;
	static int W;
	static int H;
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("src/data/sw-input1873_sample3.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스의 수
		for(int tc = 1; tc <= T; tc++) {
			
			H = sc.nextInt(); // 전장의 세로
			W = sc.nextInt(); // 전장의 가로
			battlefiled = new char[H][W]; // 전장 생성
			
			// 전장에 장애물 생성하고, 탱크 위치시킴
			for(int i = 0; i < H; i++) {
				String temp = sc.next();
				for(int j = 0; j < W; j++) {
					battlefiled[i][j] = temp.charAt(j);
				}
			} 
			
			// 명령어 미리 입력 받음
			int N = sc.nextInt();
			char[] order = new char[N];
			String temp = sc.next();
			for(int i = 0; i < N; i++) {
				order[i] = temp.charAt(i);
			}
			
			//전차의 현위치 파악 및 방향 저장
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(battlefiled[i][j] == '<') {
						tank = '<';
						r = i;
						c = j;
						break;					
					}
					else if(battlefiled[i][j] == '>') {
						tank = '>';
						r = i;
						c = j;
						break;					
					}
					else if(battlefiled[i][j] == '^') {
						tank = '^';
						r = i;
						c = j;
						break;					
					}
					else if(battlefiled[i][j] == 'v') {
						tank = 'v';
						r = i;
						c = j;
						break;					
					}
				}
			}
			
//			System.out.println("===================최초상태===================");
//			for(int i = 0; i < H; i++) {
//				for(int j = 0; j < W; j++) {
//					System.out.print(battlefiled[i][j]);
//				}
//				System.out.println();
//			}
			
			for(int i = 0; i < order.length; i++) {
				//System.out.println("==================="+ "명령어 : " + order[i] + "===================");
				if(order[i] == 'S')
					shoot();
				else
					move(order[i]);
//				for(int k = 0; k < H; k++) {
//					for(int j = 0; j < W; j++) {
//						System.out.print(battlefiled[k][j]);
//					}
//					System.out.println();
//				}
			}
			
			//System.out.println("==============================최종결과==============================");
			System.out.print("#" + tc + " ");
			//System.out.println();
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(battlefiled[i][j]);
				}
				System.out.println();
			}
			
		}
	}
	
	static void shoot() {
		if(tank == '<') {
			for(int i = c; i >= 0; i--) {
				if(battlefiled[r][i] == '*') {
					battlefiled[r][i] = '.';
					break;					
				}else if(battlefiled[r][i] == '#') {
					break;
				}
			}
		}
		else if(tank == '>') {
			for(int i = c; i < W; i++) {
				if(battlefiled[r][i] == '*') {
					battlefiled[r][i] = '.';
					break;	
				}else if(battlefiled[r][i] == '#') {
					break;
				}
			}
		}
		else if(tank == '^') {
			for(int i = r; i >= 0; i--) {
				if(battlefiled[i][c] == '*') {
					battlefiled[i][c] = '.';
					break;
				}else if(battlefiled[i][c] == '#') {
					break;
				}
			}
		}
		else if(tank == 'v') {
			for(int i = r; i < H; i++) {
				if(battlefiled[i][c] == '*') {
					battlefiled[i][c] = '.';
					break;					
				}else if(battlefiled[i][c] == '#') {
					break;
				}
			}
		}
	}
	
	static void move(char vector) {
		char temp = 'O';
		
		switch(vector) {
		case 'U':
			tank = '^'; //방향
			if(r-1 >= 0) {
				temp = battlefiled[r-1][c];
				if(temp != '*' && temp != '#' && temp != '-') {
					battlefiled[r][c] = '.';
					r = r - 1;
				}	
			}
			battlefiled[r][c] = tank;//적용
			break;
		case 'D':
			tank = 'v';
			if(r+1 < H) {
				temp = battlefiled[r+1][c];
				if(temp != '*' && temp != '#' && temp != '-') {
					battlefiled[r][c] = '.';
					r = r + 1;
				}
			}
			battlefiled[r][c] = tank;
			break;
		case 'L':
			tank = '<';
			if(c - 1 >= 0) {
				temp = battlefiled[r][c-1];
				if(temp != '*' && temp != '#' && temp != '-') {
					battlefiled[r][c] = '.';
					c = c - 1;
				}
			}
			battlefiled[r][c] = tank;
			break;
		case 'R':
			tank = '>';
			if(c + 1 < W) {
				temp = battlefiled[r][c+1];
				if(temp != '*' && temp != '#' && temp != '-') {
					battlefiled[r][c] = '.';
					c = c + 1;
				}
			}
			battlefiled[r][c] = tank;
			break;
		}
	}
}
