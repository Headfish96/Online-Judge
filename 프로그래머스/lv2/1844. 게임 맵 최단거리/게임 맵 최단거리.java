import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<point> q = new ArrayDeque<>();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int r, c = 0;
        int cnt = 0;
        boolean flag = true;
        q.add(new point(0,0));
        int n = maps.length;
        int m = maps[0].length;
        
        while(!q.isEmpty() && flag) {
            for(int j = 0, size = q.size(); j < size; j++){
                point current = q.poll();
                r = current.r;
                c = current.c;
                
                if(maps[r][c] == 0) continue;
                maps[r][c] = 0;
                
                for(int i = 0; i < 4; i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && maps[nr][nc] == 1) {
                        q.add(new point(nr, nc));
                        if(nr == (n-1) && nc == (m-1)) flag = false;
                    }
                }
                
            }
            cnt++;
            if(q.isEmpty()) cnt = -1;
        }
        int answer = 0;
        if(cnt == -1) answer = -1;
        else answer = cnt+1;
        return answer;
    }
    
    static class point{
        public int r,c;
        public point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
}
