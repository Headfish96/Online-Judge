import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	static int T; //테스트케이스의 수
	static int N; //재료의 수
	static int R;
	static int L; //제한 칼로리
	static int[] numbers;
	static int[] input;
	static boolean[] selected;
	static int[][] calAndtaste;
	static int max;
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("src/data/sw-input5215.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt(); //테스트 케이스의 개수를 받는다.
		for(int tc = 1; tc <= T; tc++) {
			max = 0;
			N = sc.nextInt(); //재료의 개수를 받는다.
			L = sc.nextInt(); //제한 칼로리를 받는다.
			input = new int[N];
			calAndtaste = new int[N][2];
			selected = new boolean[N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 2; j++) {
					calAndtaste[i][j] = sc.nextInt();
				}
			}
			for(int i = 0; i < N; i++) {
				input[i] = i; //조합될 인덱스를 저장하는 배열
			}
			subset(0);
			System.out.println("#" + tc + " " + max);
		}
	}
	private static void subset(int cnt) {
		if(cnt == N) {
			int cal = 0;
			int taste = 0;
			for(int i = 0; i < N; i++) {
				if(!selected[i]) continue;
				//N개의 재료로 만들 수 있는 부분집합에서 그 칼로리를 더한다.
				// ex) 5개 중 3개 0, 2, 3인덱스면 200 + 300 + 1000
				//System.out.print(input[i] + " ");
				cal += calAndtaste[input[i]][1]; // N개의 재료
				if(cal > L) return;
				taste += calAndtaste[input[i]][0];
			}
			//System.out.print("칼로리의 합계: " + cal);
			//System.out.print(" 맛의 합계: " + taste);
			max = Math.max(max, taste);
			//System.out.println();
			return;
		}
		selected[cnt] = true;
		subset(cnt + 1);
		selected[cnt] = false;
		subset(cnt + 1);
	}
}