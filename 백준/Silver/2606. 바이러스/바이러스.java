import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int N;
    static int[][] board;
    static int count;

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited =  new boolean[N+1];
        board = new int[N+1][N+1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                board[i][j] = 0;
            }
        }

        for(int i = 1; i <= M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
            board[b][a] = 1;
        }
        dfs(1);
        System.out.println(count);
    }

    public static void dfs (int start){
        visited[start] = true;
        for(int i = 1; i <= N; i++){
            if(board[start][i] == 1 && visited[i] == false){
                count++;
                dfs(i);

            }
        }
    }
}