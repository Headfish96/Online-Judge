import java.util.*;

class Solution{
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int hp = 0;
        hp = health;
        // 유저가 죽거나 모든 공격이 끝날 때까지 반복한다.
        for(int i = 0; i < attacks.length; i++){
            if(i != 0) {
                int time = 0;
                time = attacks[i][0] - attacks[i-1][0]-1; // 이전 공격부터 현재 공격까지의 시간
                int extra = time / bandage[0]; // 추가 회복이 몇번 이뤄질 수 있는지 확인
                int heal = time*bandage[1] + extra*bandage[2];
                System.out.println("회복량: " + heal);
                hp = hp + heal;
                // 만약 유저의 체력이 최대 체력을 초과하면 최대 체력까지만 회복한다.
                if(hp >= health){
                    hp = health;
                }
            }
            
            System.out.println("유저의 현재 체력: " + hp);
            
            // 공격이 현재 남아있는 체력보다 높으면 유저는 죽는다.
            if(attacks[i][1] >= hp){
                hp = 0;
                answer = -1;
                break;
            }
            
            // 현재 남아있는 체력이 공격보다 높으면 유저는 살아남는다.
            else if(attacks[i][1] < hp){
                // 체력은 줄어든다.
                hp = hp - attacks[i][1];
                System.out.println("공격당하고 나서의 체력: " + hp);
                // 만약 마지막 공격이었다면, 그 상태를 리턴하고 종료한다.
                if(i == attacks.length - 1){
                    answer = hp;
                    break;
                }
            }
        }
        return answer;
    }
}


// 마지막 공격이 아니라면 지금 공격받은 시점부터 다름 공격까지의 시간을 구하고 회복량을 구한다.
                