

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T[]; // 상담을 하는데에 걸리는 일수
	static int P[]; // 상담을 완료했을 때 얻는 이익
	static int N; //퇴사까지 남은 기간: 상담할 수 있는 일수
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		max = 0;
		setMaxProfit(0,0);
		System.out.println(max);
		
	}
	static void setMaxProfit(int day, int sum) {
		if(day > N) return;
		if(day == N) {
			if(max < sum) max = sum;
			return;
		}
		setMaxProfit(day + 1, sum);
		setMaxProfit(day + T[day], sum + P[day]);
	}
}
