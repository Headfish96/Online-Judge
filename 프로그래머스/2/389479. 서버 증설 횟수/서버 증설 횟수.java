import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        System.out.println("서버 한 대로 감당할 수 있는 최대 이용자: " + m);
        System.out.println("서버 한 대가 운영 가능한 시간: " + k);
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        
        int increaseCount = 0; // 증설 횟수
        for(int i  = 0; i < 24; i++){
            int serverCount = 0; // 현재 운용 중인 서버의 개수
            // {해당 시각에 증설한 서버의 수, 잔여시간} 이 들어있는 큐가 비어있지 않다면
            if(!dq.isEmpty()){
                // 큐를 순회하면서 잔여시간을 갱신하고, 잔여시간이 남아있는 서버의 수를 센다.
                int len = dq.size();
                for(int j = 0; j < len; j++){
                    int[] temp = dq.pollFirst();
                    temp[1] -= 1; // 잔여시간을 갱신한다
                    if(temp[1] != 0){ // 갱신한 후 잔여 시간이 0이 아니라면   
                        serverCount += temp[0]; // 현재 운용 중인 서버의 개수에 합산한다.
                        dq.addLast(new int[]{temp[0], temp[1]}); // 다시 큐에 넣는다.
                    }
                }
            }
            
            System.out.println(i + ": 증설 전 운용 중인 서버의 수: " + serverCount);
            
            // 현재 운용하고 있는 서버보다 필요한 서버가 더 많을때 증설이 이루어진다.
            if(serverCount < players[i]/m) {
                System.out.println("증설 시각: " + i + "~" + (i+1));
                int temp = players[i]/m - serverCount;
                System.out.println("증설 서버의 수: " + temp);
                dq.addLast(new int[]{temp, k});
                increaseCount += temp;
                System.out.println(" 증설 후 현재 운용 중인 서버의 수: " + (serverCount + temp));
            }
            
            
        }
        System.out.println(increaseCount);
        int answer = increaseCount;
        return answer;
    }
}