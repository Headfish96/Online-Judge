import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[][] area;
    static int N;
    static StringBuilder dfsSb;
    static StringBuilder bfsSb;

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        dfsSb = new StringBuilder();
        bfsSb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        area = new int[N+1][N+1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                area[i][j] = 0;
            }
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            area[r][c] = 1;
            area[c][r] = 1;
        }
        visited = new boolean[N+1];
        dfs(V);
        System.out.println(dfsSb);

        visited = new boolean[N+1];
        bfs(V);
        System.out.println(bfsSb);
    }

    public static void dfs(int start){
        visited[start] = true;
        dfsSb.append(start).append(" ");
        for(int i = 1; i <= N; i++){
            if(area[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
    public static void bfs(int start){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(start);
        while (!arrayDeque.isEmpty()){
            int temp = arrayDeque.pop();
            if(!visited[temp]){
                bfsSb.append(temp).append(" ");
            }
            visited[temp] = true;
            for(int i = 1; i <= N; i++) {
                if(area[temp][i] == 1 && !visited[i]){
                    arrayDeque.add(i);
                }
            }
        }
    }
}