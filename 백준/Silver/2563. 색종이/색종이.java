

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //색종이의 수가 주어진다.
		
		int[][] paper = new int[100][100]; //100 by 100 인 도화지
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()); //첫번째 자연수는 x 좌표
			int y = Integer.parseInt(st.nextToken()); //두번째 자연수는 y 좌표
			int width = 10; //도형의 크기는 10으로 고정
			int height = 10;//도형의 크기는 10으로 고정
			
//			for(int j = x; j < x + 10; j++) {
//				for(int k = y; k < y + 10; k++) {
//					paper[j][k] = i;
//				}
//			}
			for(int j = x; j < x + 10; j++) {
				for(int k = y; k < y + 10; k++) {
					paper[j][k] = 1;
				}
			}
			
		}
		
		int count = 0;
		for(int j = 0; j < 100; j++) {
			for(int k = 0; k < 100; k++) {
				if(paper[j][k] == 1) {
					count += 1;
				}
			}
		}
		
//		int count = 0;
//		for(int i = 1; i <= N; i++) {
//			for(int j = 0; j < 100; j++) {
//				for(int k = 0; k < 100; k++) {
//					if(paper[j][k] == i) {
//						count += 1;
//					}
//				}
//			}
//		}
		System.out.println(count);
		
	}
}
