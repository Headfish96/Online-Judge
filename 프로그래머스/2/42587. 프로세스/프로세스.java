import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> deque = new ArrayDeque<>();
        int value = 0;
        for(int i = 0; i < priorities.length; i++){
            deque.addLast(new int[]{priorities[i], value});
            value++;
        }
        for (int[] pair : deque) {
            System.out.println(pair[0] + ", " + pair[1]);
        }
        int count = 0;
        int answer = 0;
        while(!deque.isEmpty()){
            boolean flag = true;
            int[] pop = deque.pop();
            for(int[] pair : deque){
                if(pop[0] < pair[0]) {
                    deque.addLast(pop);
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                count++;
                if(pop[1] == location){
                    answer = count;
                    return answer;
                }
            }
        }
        return answer;
    }
}