import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int num, int total) {
        /*
        n+0, n+1, n+2, ... , n + (num-1)
        n은 num개만큼있고
        0+1+..+(num-1)
        int sum = 0;
        for(int i = 0; i < num; i++){
        sum += i;
        }
        */
        int[] answer = new int[num];
        int start = 0;
        int sum = 0;
        for(int i = 0; i < num; i++){
            sum += i;
        }
        
        start = (total - sum)/num;
        for(int i = 0; i < num; i++){
            answer[i] = start + i;
        }
        
        return answer;
    }
}