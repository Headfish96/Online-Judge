import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]); // 두 번째 열 기준으로 비교
            } else {
                return a[0].compareTo(b[0]); // 첫 번째 열 기준으로 비교
            }
        });
        
        // for(int i = 0; i < book_time.length; i++){
        //     for(int j = 0; j < book_time[i].length; j++){
        //         System.out.print(book_time[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        /*
        방문배열을 쓰면 될 것 같은데?
        방문배열을 대실 예약 갯수만큼 설정을 한다.
        그리고 반복문을 돌면서
        기준이 되는 예약 건은 방문으로 처리하지만
        조건문에 만족해서 같은 방에서 처리가 가능하면 visit에서 그것도 방문으로 처리한다.
        그러면 자연스럽게 i가 다음 i로 넘어갈때 방문하지 않은 경우에만 방 수를 늘리면 된다.
        */
        boolean[] visited = new boolean[book_time.length];
        int count = 0;
        for(int i = 0; i < book_time.length; i++){
            if(visited[i] == true) continue;
            visited[i] = true;
            count++;
            
            String[] parts = book_time[i][1].split(":");
            int endHour = Integer.parseInt(parts[0]); // i번째 에약 종료 시
            int endMin = Integer.parseInt(parts[1]); // i번째 예약 종료 분
            // System.out.println(i + "번째 예약 종료시각: " + endHour + ":" + endMin);
            int currentEndTime = endHour*60 + endMin + 10;
            
            for(int j = i+1; j < book_time.length; j++) {
                if(visited[j] == true) continue;
                
                parts = book_time[j][0].split(":");
                int startHour = Integer.parseInt(parts[0]); // j번째 예약 시작 시
                int startMin = Integer.parseInt(parts[1]); // j번째 예약 시작 분
                // System.out.println(j + "번째 예약 시작시각: " + startHour + ":" + startMin);
                int nextStartTime = startHour*60 + startMin;
                
                if(currentEndTime <= nextStartTime){
                    visited[j] = true;
                    parts = book_time[j][1].split(":");
                    currentEndTime = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]) + 10;
                }
            }
        }
        
        // System.out.println(count);
        int answer = count;
        return answer;
    }
}