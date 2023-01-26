import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] area;
	static int area_length;
	static boolean[][] visited;
	static int num_area = 0; // 단지의 수
	static int house_num; // 집의 수를 나타내는 변수

	public static void main(String[] args) {

		int num_area = 0; // 단지의 총 숫자를 나타내는 변수 선언 및 0으로 초기

		Scanner sc = new Scanner(System.in);
		area_length = sc.nextInt(); // 땅의 길이를 받았다.
		area = new int[area_length][area_length]; // 땅의 길이를 한 변으로 하는 정사각 행렬 선언
		visited = new boolean[area_length][area_length]; // 방문한 좌표를 표시하기 위한 boolean 타입의 정사각행렬 선언

		String row; // 한 줄씩 띄어쓰기 없는 숫자를(문자로) 입력받음. 한 줄에 대한 변수 row 선언
		for (int r = 0; r < area_length; r++) { // 정사각행렬이니 그 줄의 수 만큼 입력받
			row = sc.next();
			String[] num = row.split(""); // 띄어쓰기 없이 0과 1로 입력 받았으니 한개 씩 떼어내는 작업을 진
			for (int c = 0; c < area_length; c++) {
				area[r][c] = Integer.parseInt(num[c]); // 떼어낸 문자(0과1)을 숫자 int 타입으로 해당 좌표에 대입
			}
		}

		/*
		 * 행렬이 잘 입력되었는지 확인차 출력
		 * for (int r = 0; r < area_length; r++) 
		 * 	{ for (int c = 0; c < area_length; c++) { System.out.print(area[r][c]); } System.out.println(); }
		 */

		int[] house = new int[area_length * area_length]; // 집의 수를 저장할 배열 선언

		for (int r = 0; r < area_length; r++) {
			for (int c = 0; c < area_length; c++) {
				if (1 == area[r][c] && visited[r][c] == false) {
					house_num = 1; // 위의 조건을 만족해서 if문이 실행되었으면 무조건 집의 수와 단지의 수는 1이다.
					DFS(r, c);
					 // DFS가 종료되었으면 단지의 수를 증가시킨다.
					house[num_area] = house_num; // 해당 단지가 가지고 있는 집의 수를 저장
					num_area++;
				}
			}
		}
		
		System.out.println(num_area); // 첫 번째 줄에 총 단지수를 출력한다.
		
		/*
		for (int i = 0; i < num_area; i++) {
			System.out.println(house[i]);
		} // 각 단지의 집의 수를 출력한다.
		*/
		
		for(int i = 0; i < num_area - 1; i++) {
			int minIdx = i;
			for(int j = i+1; j < num_area; j++) {
				if(house[minIdx] <= house[j]) continue;
				minIdx = j;
			}
			if(i == minIdx) continue;
			
			int temp = house[minIdx];
			house[minIdx] = house[i];
			house[i] = temp;
		}
		
		
		for (int i = 0; i < num_area; i++) {
			System.out.println(house[i]);
		} // 각 단지의 집의 수를 출력한다.
	}

	static void DFS(int r, int c) {
		visited[r][c] = true;

		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (0 <= nr && nr < area_length && 0 <= nc && nc < area_length) {
				if (0 < area[nr][nc] && visited[nr][nc] == false) {
					DFS(nr, nc);
					house_num++; // 1이 있는 좌표를 찾아서 DFS가 실행되었으면, DFS가 재귀 내에서 몇번 실행되었는지가 집의 수이다.
				}
			}
		}
	}

}