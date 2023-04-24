import java.util.*;
import java.io.*;


class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        System.out.println("다리의 길이: " + bridge_length);
        System.out.println("차량의 수: " + truck_weights.length);
        System.out.println("다리가 버틸 수 있는 무게: " + weight);
        
        /*
        트럭들의 무게 정보를 담고있는 stack을 하나 선언한다. 이하 truckStack이라 하자.
        다리를 구현한 Queue를 하나 선언한다. 이하 bridgeQue라 하자.
        다리 위에 올라가있는 트럭들의 무게의 합을 담는 변수를 하나 선언한다. 이하 sum이라 하자.
        트럭들이 전부 다리를 통과하는 시간을 측정하는 변수를 하나 선언한다. 이해 cnt라 하자.
        
        1. 큐가 전부 비어있다면
        1-1. 스택에서 하나를 뽑아서 큐에다가 넣어준다.
        1-2. 이때 cnt의 값을 1 증가시킨다.
        1-3. 이때 sum에 스택에서 뽑은 값, 즉 트럭의 무게를 더해준다.
        
        2. 큐가 꽉 차지 않았을때
        2-1. 가장 위에 있는 스택의 값과 sum의 값을 더했을때 weight를 초과하는지 확인한다.
        2-2. 초과하지 않는다면 스택에서 하나 뽑아서 큐에다가 넣어주면서 cnt의 값을 1 증가시키고 sum에 뽑은 값을 더해준다.
        2-3. 초과한다면 0을 큐에 넣어주면서 cnt의 값을 1 증가시킨다.

        3. 큐가 꽉 찼을때
        3-1. 큐의 크기가 다리의 길이와 같아지면 큐에서 선입되었던 한가지를 뺀다.
        3-2. 이때 뽑은 값만큼 sum에서 빼준다.
        3-3. 이때 cnt의 값은 변하지 않는다.
        
        기저조건: 뽑으려는 stack이 텅 비어있을때 무한한복을 종료시킨다.
        이때 cnt에 값에 다리의 길이만큼 더해준 것이 정답이다.
        
        */
        Deque<Integer> bridgeQue = new ArrayDeque<>();
        Stack<Integer> truckStack = new Stack<>();
        for(int i = truck_weights.length-1; i >= 0; i--) {
            truckStack.add(truck_weights[i]);
        }
        //System.out.println(truckStack.size());
        
        
        int cnt = 0;
        int sum = 0;
        // int temp = truckStack.pop();
        // System.out.println(temp);
        while(true){
            if(truckStack.isEmpty()) break;
            
            // 큐가 비어있는 경우
            if(bridgeQue.isEmpty()) {
                int temp = truckStack.pop();
                bridgeQue.add(temp);
                sum += temp;
                cnt++;
            }
            else if(!bridgeQue.isEmpty()) {
                if(bridgeQue.size() < bridge_length) {
                   if(truckStack.peek() + sum <= weight){
                        int temp = truckStack.pop();
                        bridgeQue.add(temp);
                        sum += temp;
                        cnt++;
                    }
                    else if(truckStack.peek() + sum > weight) {
                        bridgeQue.add(0);
                        cnt++;
                    }
                }
                else if(bridgeQue.size() == bridge_length){
                    int temp = bridgeQue.poll();
                    sum -= temp;
                }
            }
            
        }
    System.out.println(cnt);
    int answer = cnt + bridge_length;
    return answer;
    }
    
}