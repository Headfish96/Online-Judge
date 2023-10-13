import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int scoreA, scoreB, scoreC = 0;
        
        int[] score = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == a[i%a.length]) score[0]++;
            if(answers[i] == b[i%b.length]) score[1]++;
            if(answers[i] == c[i%c.length]) score[2]++;
        }
        
        int max = 0;
        for(int i = 0; i < 3; i++){
            if(max < score[i]) max = score[i];
        }
        
        int cnt = 0;
        for(int i = 0; i < 3; i++){
            if(score[i] == max) cnt++;
        }
        
        int[] answer = new int[cnt];
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < 3; i++){
            if(score[i] == max) q.add(i+1);
        }
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = q.poll();
        }
        
        Arrays.sort(answer);
        return answer;
    }
}