import java.util.*;



class Solution {
    
    static boolean visited[][]; // 방문배열
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static Stack<int[]> stack; // 한 문자일때 나중에 스택만 따로 돌아서 0으로 만들어 줄 것
    static int row; // 행
    static int col; // 열
    static int[][] board; // 창고를 표현하는 이차원배열 board 선언
    
    public static void dfs(int r, int c, int[] origin){
        visited[r][c] = true; // 방문배열 해당 위치 방문처리
        int nr = 0; // 새로 탐색할 행
        int nc = 0; // 새로 탐색할 열
        for(int i = 0; i < 4; i++){ // 상하좌우 탐색
            nr = r + dr[i]; // 새로운 행
            nc = c + dc[i]; // 새로운 열
            // 상하좌우 따지는데 이동하려는게 벽의 안쪽이고 방문한 적이 없고, board의 값이 0이면 dfs 재귀 진행
            if(0 <= nr && nr < row && 0<= nc && nc < col && visited[nr][nc] == false && board[nr][nc] == 0){
                dfs(nr, nc, origin);
            }
            // 상화좌우 따지는데 이동하려는게 벽이면 끝까지 도달한 것이니 나중에 0으로 만들어줄 스택에 넣는다.
            if(nr < 0 || row <= nr || nc < 0 || col <= nc){
                // System.out.println("nr: " + nr + ", nc: " +  nc + ", row: " + row + ", col: " + col);
                // System.out.println("벽에 도달해서 board[" + r + "," + c + "] 를 스택에 넣어준다."); // 최초에 시작한 r, c를 넣어야함.
                // 그럼 dfs가 시작한 좌표 배열을 가지고 다니면 된다.
                // System.out.println();
                stack.push(origin);
                break;
            }
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        row = storage.length;
        col = storage[0].length();
        board = new int[row][col];
        
        for(int i = 0; i < storage.length; i++){
            for(int j = 0; j < storage[0].length(); j++){
                board[i][j] = storage[i].charAt(j);
            }
        }
        
        for(int i = 0; i < requests.length; i++){ // 명령을 순회한다.
            stack = new Stack<>();
            if(requests[i].length() == 1){ // 한자리 명령이면 일단 board를 순회하면서 그 문자를 찾는다.
                for(int r = 0; r < row; r++){
                    for(int c = 0; c < col; c++){
                        visited = new boolean[row][col];
                        if(board[r][c] == requests[i].charAt(0)){ // 일단 명령에 맞는 문자를 찾았으면 그 문자부터 dfs를 진행한다.
                            int[] origin = {r, c};
                            dfs(r, c, origin);
                        }
                    }
                }
            }
            // 두 자리
            else {
                for(int r = 0; r < row; r++){
                    for(int c = 0; c < col; c++){
                        if(board[r][c] == requests[i].charAt(0)){
                            // System.out.println("명령에 맞는 문자 " + requests[i] + " 를 " + "board[" + r + "," + c + "] 에서 찾음");
                            board[r][c] = 0;
                        }
                    }
                }
            }
            while(!stack.isEmpty()){
                int[] delete = stack.pop();
                int del_row = delete[0];
                int del_col = delete[1];
                // System.out.println("board" + "[" + del_row + ", " + del_col + "] = " + board[del_row][del_col]);
                board[del_row][del_col] = 0;
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] != 0) answer++;
                // System.out.print(board[i][j] + " ");
            }
            // System.out.println();
        }
        
        
        return answer;
    }
}