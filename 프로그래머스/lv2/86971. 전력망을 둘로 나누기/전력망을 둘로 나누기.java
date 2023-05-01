import java.util.*;
import java.io.*;

class Solution {
    static int[][] map;
    public int solution(int n, int[][] wires) {
        int answer = n;
        //노드가 1번부터 시작하니 0번 인덱스는 빼고 1번부터 n번까지 사용한다.
        map = new int[n+1][n+1];
        // map 이차원 배열 전부 0으로 초기화
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                map[i][j] = 0;
            }
        }
        // 연결되어 있는 노드는 양방향으로 연결
        for(int i = 0; i < wires.length; i++){
            int x = wires[i][0];
            int y = wires[i][1];
            map[x][y] = 1;
            map[y][x] = 1;
        }
        
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0]; // 1->3에서 1
            int b = wires[i][1]; // 1->3에서 3
            map[a][b] = 0;
            map[b][a] = 0;
            
            answer= Math.min(answer, bfs(n, a));
            
            map[a][b]=1;
            map[b][a]=1;
        }
        
        return answer;
    }
    public int bfs(int n, int start){
        int[] visit= new int[n+1]; // 방문배열 선언
        int cnt=1; //일단 최소 한쪽이 1 이상
        
        Queue<Integer> queue= new LinkedList<>();
        queue.offer(start); //큐에 노드번호 삽입
        
        while(!queue.isEmpty()){ //큐가 다 빌때까지 반복
            int point = queue.poll(); // 큐에 들어갔던 노드 번호 출력
            visit[point]= 1; // 해당 노드 번호는 방문한 것으로 표기
            
            for(int i=1; i<=n; i++){ //point와 연결된 애들 중에 방문한적 없는 노드 전부 큐에 넣기
                if(visit[i]==1) continue; //방문한 노드면 건너뛰기
                if(map[point][i]==1) { //출력된 노드 번호와 연결되어 있는 노드들
                    queue.offer(i); //큐에 해당 노드 번호를 넣어줌
                    cnt++; //노드가 하나 들어갈때마다 cnt값 1 증가
                }
            }
        }
        return (int)Math.abs(n-2*cnt); //cnt-(n-cnt);
    }
}