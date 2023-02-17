import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int min = Integer.MAX_VALUE;
	static int[][] board;
	static boolean[][] visited; //BFS를 돌리기위한 방문배열 선언

	//상 -> 하 -> 좌 -> 우 탐색
	static int[] dirR = {-1,1,0,0};
	static int[] dirC = {0,0,-1,1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N x M 미로를 만들기 위한 N의 값을 받는다.
		M = sc.nextInt(); // N x M 미로를 만들기 위한 M의 값을 받는다.
		board = new int[N][M]; // 미로가 그려지는 board
		visited = new boolean[N][M];
		// 미로를 BFS쓰기 위해 간선을 하나로 만들기위해 visited 배열을 만든다.
		sc.nextLine(); // 01로 이루어진 미로를 한줄씩 입력받는다. 0이 장애물이다.
		for(int i=0; i<N; i++) {
			char[] line = sc.nextLine().toCharArray();
			for(int j=0; j<M; j++) {
				int num = line[j]-'0';
				board[i][j] = num;
			}
		}
		bfs(); // 넓이 우선 탐색 시작
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		//ArrayDeque를 사용하는 int[] 타입의 변수 q

		q.offer(new int[] {0,0});
		// q라는 ArrayDeque에 {0,0}이라는 배열을 새로 생성하면서 넣어준다.

		visited[0][0] = true;
		
		int[] current;
		boolean flag = true;
		int lvl = 0; //레벨이 노드트리의 높이, 즉 거리이다!
		while(!q.isEmpty() && flag) {
			/*
			 * 큐가 비어있지 않을 경우에만 실행된다!
			 * 큐는 전부 다 탐색했을때만 비게된다!
			 * 이 부분에서 큐에 무언가가 있을 경우에 무조건 실행이 되므로 목적지에 도달하고 나서도 돌아가는 경우가 있다.
			 * 따라서 flag를 사용해서 멈출 수 있도록 하였다.
			 */
			for(int i=0, size = q.size(); i<size; i++) {
				//여기서 size는 큐안에 들어있는 노드들의 개수(노드의 크기, 사이즈)이다.

				current = q.poll(); //큐에서 뽑혀서 나온 노드를 current로 한다.
				if(current[0] == N-1 && current[1] == M-1) {
					// 만일 뽑혀 나온 노드가 도착지이면  무한루프를 멈줘야한다.
					//System.out.println("check");
					flag = false; //flag를 사용해서false로 바꾸어 무한 루프를 멈춘다.
				}


				for(int d=0; d<4; d++) {
					//뽑혀나온 current는 {0,0}의 형태이고 좌표의 값을 가지고 있다.
					
					int x = current[0]+dirR[d]; //뽑혀나온 노드의 x좌표에서 탐색
					int y = current[1]+dirC[d]; //뽑혀나온 노드의 y좌표에서 탐색
					//사방탐색
					
					if(x>=0 && x<N && y>=0 && y<M) {
					//사방탐색을하며 달라진 x,y 좌표가 범위 내에 있음
						if(visited[x][y] == false && board[x][y] == 1) {
							visited[x][y] = true;
							q.offer(new int[] {x, y});
						}
					}
				}
			}
			++lvl;
		}
		System.out.println(lvl);
	}
}