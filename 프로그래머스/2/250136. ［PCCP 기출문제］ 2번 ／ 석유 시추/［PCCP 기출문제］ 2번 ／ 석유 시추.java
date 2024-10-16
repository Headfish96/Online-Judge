import java.util.*;

class Solution {
    
    // 사방탐색을 위한 배열
    public int[] dx = new int[]{0, 1, 0, -1}; // 상, 우, 하, 좌
    public int[] dy = new int[]{-1, 0, 1, 0}; // 상, 우, 하, 좌
    // public boolean[][] visited; // 방문배열 선언
    public int area;
    public int r;
    public int c;
    public int startR;
    public int endR;
    
    public int solution(int[][] land) {
        /** 요점은 영역의 시작 열과, 종료 열, 그리고 그 영역의 크기를 저장해야한다.
        예를 들어서
        [0열, 2열] 영역의 크기는 8이고
        [3열, 6열] 영역의 크기는 7이고
        [6열, 7열] 영역의 크기는 2이다.
        그러면 이제 이걸 배열로 쭉 나열해보면
        0 1 2 3 4 5 6 7
        8 8 8
              7 7 7 7
                    2 2
        8 8 8 7 7 7 9 2
        따라서 6열에서 시추하는게 9로 가장 많은 석유를 시추할 수 있다.
        DFS를 돌리면서 한 영역의 시작 열과 종료 열, 그 영역의 크기를 알아내서 저장해야한다.
        */
        Queue<int[]> queue = new ArrayDeque<>();
        
        r = land.length; // 행
        c = land[0].length; // 열
        // visited = new boolean[r][c];
        int[] amount = new int[c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(land[i][j] == 0) continue;
                startR = 250000;
                endR = 0;
                area = 0;
                DFS(i, j, land);
                // System.out.println("시작열: " + startR);
                // System.out.println("종료열: " + endR);
                // System.out.println("이 영역의 크기: " + area);
                for(int k = startR; k <= endR; k++){
                    amount[k] += area;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < c; i++){
            // System.out.println(amount[i]);
            if(max < amount[i]) max = amount[i];
        }
        
        int answer = max;
        return answer;
    }
    
    public void DFS(int x, int y, int[][] land){
        if(land[x][y] == 1){
            // System.out.println("테스트");
            land[x][y] = 0;
            area++;
            if(y < startR) startR = y;
            if(y > endR) endR = y;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < r && 0<= ny && ny < c){
                    DFS(nx, ny, land);
                }
            }
        }
    }
}