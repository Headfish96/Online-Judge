import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        Queue<Integer> q3 = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++){
            int temp = 100 - progresses[i];
            int time = temp/speeds[i];
            //나머지가 없으면 몫만큼 시일이 걸리고
            if(temp%speeds[i] == 0){
                q1.add(time);
            }
            //나머지가 있으면 몫 + 1 만큼 시일이 걸린다.
            else {
                time = time + 1;
                q1.add(time);
            }
        }
        
        while(!q1.isEmpty()){
            //만약에 q2가 비어있다면 그건 다시 시작하거나 처음이니 무조건 하나 넣는다.
            if(q2.isEmpty()){
                q2.add(q1.poll());
            }
            //q2가 비어있지 않다면
            else{
                if(q2.peek() < q1.peek()){
                    System.out.println(q2.size());
                    q3.add(q2.size());
                    q2.clear();
                }
                else{
                    q2.add(q1.poll());
                }
            }
            
            if(q1.isEmpty()&&!q2.isEmpty()){
                q3.add(q2.size());
                System.out.println(q2.size());
            }
        }
        int i = 0;
        int[] answer = new int[q3.size()];
        while(!q3.isEmpty()){
            answer[i] = q3.poll();
            i++;
        }
        
        // int[] answer = {};
        return answer;
    }
}