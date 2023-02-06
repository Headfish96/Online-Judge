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
		int K = Integer.parseInt(st.nextToken());
		int roomNum = 0;
		
		int[][] student = new int[2][7];
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			student[S][Y] += 1;
		}
		
		/*
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j <= 6; j++) {
				System.out.print("student [" + i + ", " + j + "] = " + student[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j <= 6; j++) {
				if(student[i][j]%K != 0) {
					roomNum = roomNum + student[i][j]/K +1;
				}else if(student[i][j]%K == 0) {
					roomNum = roomNum + student[i][j]/K;
				}
			}	
		}
		System.out.println(roomNum);
	}
}
