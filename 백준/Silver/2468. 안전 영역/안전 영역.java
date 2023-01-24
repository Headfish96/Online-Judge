import java.util.*;

public class Main {
	static boolean[][] visited_area;
	static int[] dr = {-1, 1, 0, 0}; //행을 기준으로 상, 하 탐색
	static int[] dc = {0, 0, -1, 1}; //열을 기준으로 좌, 우 탐색
	
	static int area_length; //사용자에게 입력받아 생성되는 영역의 크기(길이)
	static int[][] area; //영역을 이차 배열로 선언
	
	public static void main(String[] args) {
		//System.out.println("helloworld");
		Scanner sc = new Scanner(System.in);
		area_length  = sc.nextInt(); //사용자에게 영역의 크기, 즉, 이차원 배열의 길이를 입력받음. 
		area = new int[area_length][area_length]; // 사용자에게 입력 받은 area_length의 길이만큼 정사각배열 area 정
		visited_area = new boolean[area_length][area_length]; // 방문한 좌표를 체크하는 용도로 사용할 visited_area 배열을 boolean형태로 선언
		
		int water_level_max = 0; // 수위 최고치를 저장할 변수 선언
		int water_level_min = 0; // 수위 최저치를 저장할 변수 선언
		int Max_number_of_safe_area = 0; // 안전구역 개수의 최댓값 선언. 0부터 시작해서 더 높은 값이 있으면 바꾸어준다.
		
		//사용자에게서 수위에 대한 정보를 입력받아 이차원 배열로 저장하고 수위의 최댓값과 최솟값을 구한다
		for(int r = 0; r < area_length; r++) {
			for(int c = 0; c < area_length; c++) {
				area[r][c] = sc.nextInt(); //사용자에게 받은 값을 이차원 배열에 저장
				if(water_level_max <= area[r][c]) {
					water_level_max = area[r][c];
				} // 수위의 최댓값을 구한다.
				if(area[r][c] <= water_level_min) {
					water_level_min = area[r][c];
				} // 수위의 최솟값을 구한다.
			} 
		}

		// 수위의 최솟값부터 최댓값까지 올라가며, 그에 따른 안전영역의 수를 구하고, 그 안전영역의 수의 최댓값을 구한다.
		for(int wl = water_level_min; wl <= water_level_max; wl++) {
			int num_of_safe_area = 0;
			for(int r = 0; r < area_length; r++) {
				for(int c = 0; c < area_length; c++) {
					if(visited_area[r][c] == false && area[r][c] > wl) { //아직 방문하지 않는 좌표이고 해당 좌표의 값이 수위보다 높으
						search_safe_area(r, c, wl); //안전지대를 찾는 함수를 호출하고
						num_of_safe_area++; //안전지대의 수를 늘린다
					}
				}
			}
			visited_area = new boolean[area_length][area_length]; //하나의 수위로 전 영역을 다 탐색했다면, 수위를 높여 탐색하기 위해 그 전에 미방문으로 초기
			//System.out.println("물의 높이 : " + wl + " 안전영역의 수 : " + num_of_safe_area);
			if(Max_number_of_safe_area <= num_of_safe_area) {
				Max_number_of_safe_area = num_of_safe_area;
			}
		}
		System.out.println(/*"안전영역의 최대 개수: " +*/Max_number_of_safe_area);
	}
	
	//DFS를 재귀를 사용하여 만들어 주었다.
	static void search_safe_area(int r, int c, int x) {
		visited_area[r][c] = true; //처음 해당 좌표로 갔을때 true로 바꿔줌
		int nr, nc;
		for(int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(0 <= nr && nr < area_length && 0 <= nc && nc < area_length) {
				if(x < area[nr][nc] && visited_area[nr][nc] == false) {
					search_safe_area(nr,nc,x);
				}
			}
		}
	}	
}