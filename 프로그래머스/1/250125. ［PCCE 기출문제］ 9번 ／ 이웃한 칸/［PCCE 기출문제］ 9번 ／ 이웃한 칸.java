import java.util.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        
        System.out.println("가로 길이: " + board[0].length);
        System.out.println("세로 길이: " + board.length);
        int n = board[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("확인하려는 칸: (" + h + ", " + w + " ) " + board[h][w]);
        
        int count = 0;
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        // 상: -1, 0 / 우: 0, +1 / 하: +1, 0 / 좌: 0, -1 /
        for(int i = 0; i < 4; i++){
            int a = h + dr[i];
            int b = w + dc[i];
            if( (0 <= a) && (a < board.length) && (0 <= b) && (b < board[0].length)){
                if(board[a][b].equals(board[h][w])){
                count++;
                }
            }
        }
        
        int answer = count;
        return answer;
    }
}