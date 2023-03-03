

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int l; // 데이터의 길이
	static int start; //비상연락망에서 시작되는 정점
	static int size = 101; //연락인원이 100명이라 101로 선언
	static int[] visited; //방문배열
	static int[][] graph; // 연락망을 2차원 인접행렬로 나타냄
	static Queue<Integer> queue; //간선의 가중치가 없으니 BFS
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) { //테이스트 케이스는 10개
			StringTokenizer st = new StringTokenizer(br.readLine());
			graph = new int[size][size]; //정점번호가 인덱스 번호가 되도록 하기 위해 size를 100이 아닌 101로 해서 1번 인덱스부터 시작
			queue = new LinkedList<>(); //큐 자료형에 담기는 것이 링크드리스트이다.
			visited = new int[size]; //한번 방문한 정점을 다시 방문하지 않기 위해 visited로 방문배열을 선언했다.
			//방문 배열은 정점의 수랑 같으면 되니 이차원 배열이 필요하지 않다.
			
			l = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			//인접행렬을 표시해준다.
			for(int i = 0; i < l/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from][to] = 1;
			}
			
			System.out.print("#" + tc + " ");
			bfs(start);
			
		}
	}

	private static void bfs(int x) {
		queue.offer(x);
		visited[x] = 1;
		int max = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			max = 0;
			for(int t = 0; t < queueSize; t++) {
				int current = queue.poll();
				for(int i = 1; i < size; i++) {
					if(graph[current][i] == 1 && visited[i] == 0) {
						queue.offer(i);
						visited[i] = 1;
						max = Math.max(max, i);
					}
				}
			}
			list.add(max); // 최댓값 추가
		}
		System.out.print(list.get(list.size()-2));
		System.out.println();
	}
	
}
