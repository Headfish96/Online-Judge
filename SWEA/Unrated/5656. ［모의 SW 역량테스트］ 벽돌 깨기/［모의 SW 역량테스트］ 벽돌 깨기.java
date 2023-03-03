import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 * <문제 아이디어>
 * 이 문제는 결국에 구슬의 숫자가 주어졌을때 그 구슬들을 어디에 떨어트렸을때 벽돌이 가장 많이 깨지느냐를 묻는 문제이다.
 * 따라서 BFS를 활용하여 1열부터 W까지의 열이 있을때 1열에서 구슬을 떨어트려보고, 다시 2열에서 구슬을 떨어트려보고,...,W열에서 떨어트려보았을때
 * 가장 많이 벽돌이 깨지는 열을 정하고,
 * 그 다음 벽돌이 깨진 후 남은 벽돌들을 놓고 다시 1열에서 구슬을 떨어트려보고, 다시 2열에서 구슬을 떨어트려보고,...,W열에서 떨어트려보았을때
 * 가장 많이 벽돌이 깨지는 열을 정한다.
 * 위의 작업을 구슬이 0개 이상 남았을때 벽돌이 전부 깨지는 경우
 * 구슬을 다 썼는데 벽돌이 0개 이상 남는 경우
 * 위 두가지 경우가 될 때까지 반복한다.
 * 따라서 이 반복은 재귀를 사용할 수 있다.
 * 
 * 
 * <내가 생각한 아이디어> - 완전탐색...
 * 열이 주어지고 맵이 주어졌다.
 * 그럼 구슬이 떨어지는 순서가 관계가 있으니, 열의 인덱스를 가지고 구슬의 수만큼 뽑아서 나열하는 경우의 순열로 보고
 * 그 순열의 경우의 수를 뽑은 다음, 그 인덱스 별로 시뮬레이션을 돌려서 결과를 뽑는다. 여기서 결과는 남은 벽돌의 개수이고
 * 남은 벽돌의 개수가 가장 적은 개수를 출력한다.
 * 또한 그 순열의 경우로 시뮬레이션을 돌릴때 벽돌이 모두 깨졌다면, 그 이상해도 의미가 없으므로 0을 출력하고 종료한다.
 * 
 * 
 * <결론>
 * 결국 똑같은 아이디어이다.
 * 여기서 BFS 알고리즘을 쓴 부분은 하나의 구슬을 떨어트렸을때 연쇄적으로 벽돌이 깨지는 것을 확인하기 위해 사용하였을 뿐이다.
 * 내가 한 방법은 구슬을 떨어트리는 열을 정해버렸다는 점에서 항상 최대로 지우는 것을 선택할 수가 없어 비효율적일 수는 있으나,
 * 결과적으로 한 경우에 벽돌을 부수고 내리는 행위는 구슬의 수만큼 이루어지고,
 * 모범답안은 구슬을 하나 떨어트릴때 어떤 열에서 떨어트리는 것이 최대로 벽돌을 깰 수 있는지 판단하기 위해 모든 열에서 떨어트려보고
 * 그 다음 구슬도 마찬가지로 떨어 트리니, 열의 수만큼 떨어트리는 것을 구슬의 개수만큼 반복한다.
 * 
2 4 4
0 0 0 1
1 2 3 2
1 1 1 2
1 1 1 1
 */

public class Solution {
	static boolean[] selected;
	static int[] numbers;
	static int[] input;
	static int T;
	static int N;
	static int W;
	static int H;
	static int[][] map;
	static int[] dr = {-1,1,0,0}; //상, 하, 좌, 우
	static int[] dc = {0,0,-1,1};
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken()); //테스트 케이스의 개수
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //구슬의 개수 W개 중에 중복을 허락하여 N개를 뽑아 나열하여라
			W = Integer.parseInt(st.nextToken()); //가로
			H = Integer.parseInt(st.nextToken()); //세로
			min = Integer.MAX_VALUE;
			input = new int[W];
			for(int i = 0; i < W; i++) {
				input[i] = i;
			}
			numbers = new int[N];
			map = new int[H][W];
			for(int r = 0; r < H; ++r) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < W; ++c) {
					map[r][c] = Integer.parseInt(st.nextToken()); // 벽돌의 위치와 숫자를 입력받는다.
				}
			}
			perm(0);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	private static void perm(int cnt) {
		if(cnt == N) {
			//여기에다가 map을 초기 맵을 가지고 와야한다. 새로운 순열이 뽑힐때마다 초기로 설정해야한다.
			int[][] newMap = new int[H][W];
			copy(map, newMap);
			//System.out.println(Arrays.toString(numbers));
			for(int i = 0; i < N; i++) {
				
//				System.out.println("구슬 떨어트리기 전의 상태");
//				for(int l = 0; l < H; l++) {
//					for(int j = 0; j < W; j++) {
//						System.out.print(newMap[l][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println("=======================================");
//				
//				System.out.println(numbers[i] + " 번 인덱스 열에서 구슬 낙하");
//				System.out.println("=======================================");
				
				//numbers[i]가 구슬을 떨어트리는 열의 위치이다.
				//drop(numbers[i]); //numbers[i] 열에서 구슬을 떨어트리면 변화하는 맴
				drop(numbers[i], newMap);
//				for(int l = 0; l < H; l++) {
//					for(int j = 0; j < W; j++) {
//						System.out.print(newMap[l][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println("구슬 낙하 직후 상태");
//				System.out.println("=======================================");
				
				//여기에서 벽돌을 내려야한다. 구슬 한번 떨어트려서 터트린 다음에 벽돌 정렬 다시 하고 또 떨어트려야한다.
				down(newMap);
				int count = 0;
				for(int l = 0; l < H; l++) {
					for(int j = 0; j < W; j++) {
						//System.out.print(newMap[l][j] + " ");
						if(newMap[l][j]!=0) {
							count++;
						}
					}
					//System.out.println();
				}
				min = Math.min(count, min);
//				System.out.println("구슬 낙하 후 재정렬한 상태");
//				System.out.println("=======================================");
			}
			return;
		}
		for(int i = 0; i < W; i++) {
			numbers[cnt] = input[i];
			perm(cnt + 1);
		}
		
	}
	
	private static void drop(int dropCol, int[][] map) {
		int r = 0;
		while(r < H && map[r][dropCol] == 0) ++r;
		if(r == H) return; //만일 dropCol 열에 모든 행에 벽돌이 없다면 리턴한다.
//		System.out.println(r + " 번 행 " + dropCol  +" 번 열에 벽돌이 있다.");
//		System.out.println("그 벽돌이 가지고 있는 숫자는 " + map[r][dropCol] + " 이다.");
		dfs(r, dropCol, map[r][dropCol], map);
	}
	
	//구슬이 임의의 한 열에서 떨어졌을때, 연쇄적으로 깨지는 벽돌을 계산
	private static void dfs(int r, int c, int k, int[][] map) { // r은 벽돌의 행, c 는 벽돌의 열, k는 벽돌에 그려져 있는 숫자 
//		System.out.println("연쇄적으로 깨지는 벽돌의 크기: " + k);
		map[r][c] = 0;
		for(int i = 0; i <= k-1; i++) {
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d]*i;
				int nc = c + dc[d]*i;
				if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
				if(map[nr][nc] <= 1) {
					map[nr][nc] = 0;
				}
				else if(map[nr][nc] > 1) {
					dfs(nr, nc, map[nr][nc], map);
				}
			}
		}
	}
	
	private static void copy(int[][] map, int[][] newMap) {
		for(int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}
	
	private static Stack<Integer> stack = new Stack<>();
	private static void down(int[][] map) {
		//맨 아래행부터 위쪽 들여다보며 빈칸 만날때마나 내려놓을 벽돌 찾기
		//swap으로 직접 바꿔가면서 내릴 수도 있지만 쉬운 방법이 있다.
		//stack같은 자료구조를 쓰면 된다.
		//자료구조를 써서 직접 구현해보자!
		
		/*
		 * <아이디어 설명>
		 * 위쪽부터 빼서 스택에 집어넣고 빼서 아래쪽부터 다시 채운다.
		 * 넣었다가 다 빼서 배열에 세팅할 것임
		 */
		
		//각 열에 대해 윗행부터 아래 행까지 벽돌만 스택에 넣어두고 빼서 아래행부터 채우기
		for (int c = 0; c < W; c++) {
			for (int r = 0; r < H; r++) {
				if(map[r][c] > 0) {
					stack.push(map[r][c]);
					map[r][c] = 0;
				}
			}
			int r = H - 1;
			while(!stack.isEmpty()) {
				map[r--][c] = stack.pop();
			}
		}
	}
	
}