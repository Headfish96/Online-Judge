import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        /* 금 토 일 월 화 
        startday가 5면 금요일이고 실출근 배열에서 6-7 = 1 따라서 1번, 2번은 주말
        startday가 4면 목요일이고 실출근 배열에서 6-4 = 2 따라서 2번, 3번은 주말
        */
        int prizeCnt = 0;
        for(int i = 0; i < timelogs.length; i++){
            int cnt = 0;
            // System.out.println(i + "번 근무자: ");
            for(int j = 0; j < timelogs[i].length; j++){
                // 주말은 비교할 필요 없음
                if(j == (6-startday+7)% 7 || j == (7-startday+7)%7) continue;
                else {
                    int rHH = timelogs[i][j]/100 * 60;
                    int rMM = timelogs[i][j]%100;
                    // System.out.print(" 출근시각: " + timelogs[i][j]/100 + ":" + rMM + " / ");
                    int wHH = schedules[i]/100 * 60;
                    int wMM = schedules[i]%100;
                    // System.out.print(" 희망시각: " + schedules[i]/100 + ":" + wMM + " / ");
                    int real_time = rHH + rMM;
                    int work_time = wHH + wMM;
                    if(real_time <= work_time + 10){
                        // System.out.print(" 출근성공!");
                        cnt++;
                    } else {
                        // System.out.print(" 지각!");
                    }
                }
                // System.out.println();
            }
            if(cnt == 5){
                // System.out.println(i+" 번 근무자 수상");
                prizeCnt++;
            }
        }
        int answer = prizeCnt;
        return answer;
    }
}