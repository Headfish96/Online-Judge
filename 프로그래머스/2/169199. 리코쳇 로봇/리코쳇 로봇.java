class Solution {
    static int[][] map; // 주어지는 보드의 정보를 담는 배열. 비어있으면 0, 장애물이면 1, 목적지는 2, 출발지는 3
    static int[] dr = {-1, 1, 0, 0}; // 행을 기준으로 상하 탐색
    static int[] dc = {0, 0, -1, 1}; // 열을 기준으로 좌우 탐색
    static boolean found; // 목적지에 도착했는지 확인하는 변수
    static int minCount; // 몇번 이동하는지 확인하는 변수
    static int[][] minDist; // 해당 지점까지 도착하기 위한 방향 전환의 최소 횟수
    
    public static void dfs(int r, int c, int count) {
        if (count >= minDist[r][c]) return; // 이번 경로로 map[r][c]에 도착했는데 다른 경로가 더 적은 횟수로 가능하면 더 진행 필요 없음
        
        minDist[r][c] = count; // 그렇지 않다면 최솟값을 갱신하거나 첫 번째 방문일 경우 무조건 들어감
        
        if(map[r][c] == 2) { // 목적지를 찾았다면 found를 바꾸고 return
            found = true;
            minCount = Math.min(minCount, count);
            return;
        }
        int nr; // 새롭게 방문하는 주소가 들어갈 nr 선언
        int nc; // 새롭게 방문하는 주소가 들어갈 nc 선언
        for(int i = 0; i < 4; i++){ // 상하좌우로 이동
            nr = r;
            nc = c;
            while(true) {// 이동하려는 지점이 맵을 벗어나거나, 장애물이 있는 지점이 아니라면 반복
                int nextR = nr + dr[i];
                int nextC = nc + dc[i];
                int rlength = map.length;
                int clength = map[0].length;
                if(nextR < 0 || rlength <= nextR || nextC < 0 || clength <= nextC) break; // 벽에 부딛힘
                if(map[nextR][nextC] == 1) break; // 장애물에 부딛힘
                nr = nextR;
                nc = nextC;
            }
            
            if (nr == r && nc == c) continue; // 멈춘 지점이 현재와 동일하면 이동 불가. 다른 방향 찾아야함.
            
            dfs(nr, nc, count + 1); // 다음 DFS 탐색 (벽에 부딪혔으므로 count + 1)
        }
    }
    
    public int solution(String[] board) {
        int rowLength = board.length;
        int colLength = board[0].length();
        
        minDist = new int[rowLength][colLength];
        found = false; // 목적지 도착 여부 확인 변수 초기화
        int count = 0; // 방향 전환을 세는 변수 한마디로 경계나, 장애물에 부딛힌 횟수를 세는거다.
        minCount = Integer.MAX_VALUE;
        map = new int[rowLength][colLength];
        
        // 출발점 좌표 구하기
        int startR = 0;
        int startC = 0;
        
        // String 배열 board를 int형 이차원배열 map으로 치환
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(board[i].charAt(j) == '.') map[i][j] = 0;
                if(board[i].charAt(j) == 'D') map[i][j] = 1;
                if(board[i].charAt(j) == 'G') map[i][j] = 2;
                if(board[i].charAt(j) == 'R') {
                    map[i][j] = 3;
                    startR = i;
                    startC = j;
                }
                minDist[i][j] = Integer.MAX_VALUE; // 초기값 무한대
            }
        }
        
        // 깊이 우선 탐색 시작
        dfs(startR, startC, 0);
        
        int answer = 0;
        if (found) { // 목적지에 방문했을 경우 그 거리
            answer = minCount;
        } else { // 목적지에 방문하지 못했을 경우 -1
            answer = -1;
        }
        return answer;
    }
}