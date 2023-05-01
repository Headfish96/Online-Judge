import java.util.*;
import java.io.*;

class Solution {
    static boolean[] selected;
    static int N, R;
    static int[] numbers, input;
    static int stamina;
    static int score;
    static int max;
    public int solution(int k, int[][] dungeons) {
        stamina = k;
        N = dungeons.length;
        numbers = new int[N];
        input = new int[N];
        selected = new boolean[N];
        score = 0;
        for(int i = 0; i < N; i++){
            input[i] = i;
        }
        max = 0;
        perm(0, dungeons);
        int answer = max;
        return answer;
    }
    
    private static void perm(int cnt, int[][] dungeons) {
		if(cnt == N) {
            score = 0;
            int st = stamina;
            for(int i = 0; i < numbers.length; i++){
                int temp = numbers[i];
                // 스테미너가 최소 필요 피로도 보다 크거나 같을 경우
                if(dungeons[temp][0] <= st){
                    st = st - dungeons[temp][1];
                    score++;
                }
                max = Math.max(max, score);
            }
			return;
		}
		for(int i = 0; i < N; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			numbers[cnt] = input[i];
			perm(cnt + 1, dungeons);
			selected[i] = false;
		}
	}
}