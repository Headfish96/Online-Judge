import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		//System.out.println("helloworld");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] paper = new int[1001][1001];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			for(int j = x; j < x + width; j++) {
				for(int k = y; k < y + height; k++) {
					paper[j][k] = i;
				}
			}
		}
		
		/*
		for(int j = 0; j < 1001; j++) {
			for(int k = 0; k < 1001; k++) {
				System.out.print(paper[j][k] + " ");
			}
			System.out.println();
		}
		*/
		
		
		
		for(int i = 1; i <= N; i++) {
			int count = 0;
			for(int j = 0; j < 1001; j++) {
				for(int k = 0; k < 1001; k++) {
					if(paper[j][k] == i) {
						count += 1;
					}
				}
			}
			System.out.println(count);
		}
		
	}
}
