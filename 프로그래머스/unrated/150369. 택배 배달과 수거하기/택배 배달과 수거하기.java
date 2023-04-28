import java.util.*;
import java.io.*;

class Solution {
    static int scap;
    static int distance;
    static int current;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        scap = cap;
        Stack<Integer> dstack = new Stack<>();
        Stack<Integer> pstack = new Stack<>();
        for(int i = 0; i < deliveries.length; i++){
            dstack.add(deliveries[i]);
            pstack.add(pickups[i]);
        }
        
        long answer = 0;
        while(!dstack.isEmpty() || !pstack.isEmpty()){
            // System.out.println(truck(dstack, cap));
            // System.out.println(truck(pstack, cap));
            answer += 2*(Math.max(truck(dstack, cap) , truck(pstack, cap)));
        }
        
        
        return answer;
    }
    
    static int truck(Stack<Integer> stack, int cap){
        int distance = 0;
        while(cap != 0 && !stack.isEmpty()) {
            if(stack.peek() == 0){
                stack.pop();
                continue;
            }
            if(distance == 0) distance = stack.size();
            int current = stack.pop();
            if(current < cap){
                cap -= current;
            }
            else {
                current -= cap;
                cap = 0;
                stack.add(current);
            }
        }
        return distance;
    }
}