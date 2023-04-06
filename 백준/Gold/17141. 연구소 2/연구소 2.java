import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] lab;
	static int[][] virus;
	static int numLocVirus;
	static int[] numbers, input;
	static int min;
	static boolean[][] visited; //BFS를 돌리기위한 방문배열 선언
	
	//상 -> 하 -> 좌 -> 우 탐색
		static int[] dirR = {-1,1,0,0};
		static int[] dirC = {0,0,-1,1};
	
	public static void main(String[] args) {
		
//		System.out.println("helloworld");
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 연구소의 크기
		M = sc.nextInt(); // 바이러스의 개수
		lab = new int[N][N];
		virus = new int[N*N][2];
		min = Integer.MAX_VALUE;

		/*
		 * virus[1][0] => 바이러스가 올 수 있는 장소 1번 스팟의 x좌표
		 * virus[1][1] => 바이러스가 올 수 있는 장소 1번 스팟의 y좌표
		 */
		numLocVirus = 0;

		//lab의 구성 정보 입력
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < N; j++) {
				lab[i][j] = sc.nextInt();
				if(lab[i][j] == 2) {
					numLocVirus++;
					virus[numLocVirus][0] = i;
					virus[numLocVirus][1] = j;
				}
			}
		}
		
		// lab의 구성 출력
//		for(int i = 0; i < N ; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(lab[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("바이러스를 놓을 수 있는 장소의 개수: " + numLocVirus);
		
//		for(int i = 1; i <= numLocVirus; i++) {
//			System.out.println(virus[i][0] + ", " + virus[i][1]);
//		}
		
		numbers = new int[M];
		input = new int[numLocVirus];
		for(int i = 1; i <= numLocVirus; i++) input[i-1] = i;
		comb(0, 0);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(min);			
		}
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == M) {
			//System.out.println(Arrays.toString(numbers));
			bfs();
			return;
		}
		for(int i = start; i < numLocVirus; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
	
	private static void bfs() {
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(lab[i][j] == 1) {
					visited[i][j] = true;
				}
			}
		}
		Queue<int[]> q = new ArrayDeque<>();
		for(int i = 0; i < M; i++) { //바이러스의 개수만큼 바이러스가 위치하는 정보를 큐에 넣어준다.
			q.offer(new int[] {virus[numbers[i]][0], virus[numbers[i]][1]});
			//numbers[i] 는 조합을 돌려서 나오는 각각의 숫자.
			//virus[numbers[i]][0] 은 numbers[i]번째 자리에 바이러스가 오니, 그 x좌표
			//virus[numbers[i]][1] 은 numbers[i]번째 자리에 바이러스가 오니, 그 y좌표
			visited[virus[numbers[i]][0]][virus[numbers[i]][1]] = true;
		}
		//그리고 이걸 M만큼 반복하면서 M개의 바이러스가 위치하는 좌표를 모두 큐에 넣어준다.
		
		int[] current; //큐에서 뽑을때의 배열
		int lvl = -1;
		
		while(!q.isEmpty()) {
			for(int i = 0, size = q.size(); i < size; i++) {
				current = q.poll();
				for(int d = 0; d < 4; d++) {
					int x = current[0] + dirR[d]; //뽑혀나온 노드의 x좌표에서 탐색
					int y = current[1] + dirC[d]; //뽑혀나온 노드의 y좌표에서 탐색
					
					if(x>=0 && x<N && y>=0 && y<N && lab[x][y] != 1 && visited[x][y] == false) {
						visited[x][y] = true;
						q.offer(new int[] {x,y});
					}
				}
			}
			++lvl;
		}
		//System.out.println(lvl);
		
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == false) cnt++;
			}
		}
		//if(cnt != 0) System.out.println("-1");
		if(cnt == 0) {
			min = Math.min(min, lvl);
		}
	}
}