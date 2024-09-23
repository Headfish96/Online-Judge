import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M; // 미로의 크기를 나타내는 변수 N, M
    static boolean[][] visited; //미로의 칸을 지나갔는지 저장하는 배열 visited
    static int[][] maze; //미로 형태를 저장하는 이차원 배열 maze
    static int[][] distance; // 최단 거리(레벨)을 기록할 배열
    static int[] dx; // 사방탐색을 위한 x축 배열
    static int[] dy; // 사방탐색을 위한 y축 배열

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N개의 줄에
        N = Integer.parseInt(st.nextToken());
        // M개의 정수로 미로가 주어진다.
        M = Integer.parseInt(st.nextToken());
        // 미로가 그려질 maze 배열 선언
        maze = new int[N][M];
        // 미로의 어딜 방문했는지 저장할 방문배열 visited 배열 선언
        visited = new boolean[N][M];
        // 거리를 저장할 배열 distance
        distance = new int[N][M];
        // 사방탐색 담당 x축 선언
        dx = new int[] {0, 1, 0, -1};
        // 사방탐색 담당 y축 선언
        dy = new int[] {-1, 0, 1, 0};

        // 미로를 나타내는 숫자열을 분리해서 maze 배열에 넣는다.
        for (int i = 0; i < N; i++) {
            String numbers = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = numbers.charAt(j) - '0';
            }
        }

        // maze가 제대로 그려졌는지 출력해본다.
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(maze[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 출발점 (0, 0)에서 BFS 시작
        BFS(0, 0);

        // 최단 거리 출력 (목적지 N-1, M-1까지의 최단 경로)
        System.out.println(distance[N-1][M-1]);
    }

    // 좌표를 저장하기 위한 Coordinate 클래스 선언
    public static class Coordinate {
        private int x, y; // private로 선언

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        // 게터 메서드
        public int getX() {
            return x;
        }
        // 게터 메서드
        public int getY() {
            return y;
        }
    }

    // 넓이 우선 탐색을 하기 위한 BFS 함수 선언
    public static void BFS(int startX, int startY) {
        // BFS를 하기 위한 queue 선언
        Queue<Coordinate> queue = new ArrayDeque<>();
        // queue에 시작점을 넣어준다.
        queue.add(new Coordinate(startX,startY));
        // 시작 좌표를 방문처리해준다.
        visited[startX][startY] = true;
        // 구해야하는 것이 지나간 '거리'가 아니라 '칸'의 수라서 출발점부터 1로 초기화한다.
        distance[startX][startY] = 1;

        while (!queue.isEmpty()){
            // 큐에서 뽑은 좌표를 저장할 Coordinate 클래스의 변수 currentCoordinate 선언
            Coordinate currentCoordiante = queue.poll();
            int x = currentCoordiante.getX();
            int y = currentCoordiante.getY();

            // 현재 방문한 한 좌표에서 상하좌우 사방탐색
            for(int d = 0; d < 4; d++){
                // 탐색할 새로운 좌표이다.
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 새롭게 방문하려는 좌표가 범위 내에 있는지 확인한다.
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    // 만약 새로운 좌표를 방문한 적이 없고 그 지점이 이동할 수 있는 곳이라면,
                    if(visited[nx][ny] == false && maze[nx][ny] == 1){
                        // 방문한 것으로 처리한다.
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.add(new Coordinate(nx, ny));
                    }
                };
            }

        }
    }
}
/**
 * 똑같은 배열을 만들어서 그 배멸의 그 자리에 거리를 표기하면 된다.
 *
 */


/**
 * 해봐야할 것
 * 1. 그 전에 풀었던 풀이법과 비교
 * 2. DFS로는 이 문제를 풀 수 없는지 확인.
 * 3. 최단 경로라면 그 거리말고 정말 어떤 경로로 가면 최단거리인지 그 경로를 구하는 방법
 */