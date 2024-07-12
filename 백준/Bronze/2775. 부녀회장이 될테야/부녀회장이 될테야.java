import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        // 층은 0층부터 있고, 호는 1호부터 있음
        // 3층 6호에 살려면 2층의 1호부터 6호, 1층의 1호부터 6호, 0층의 1호부터 6호까지의 사람들의 수의 합만큼 3층 6호에 사람이 살아야한다.
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            // 층수
            int k = Integer.parseInt(br.readLine());
            // 호수
            int n = Integer.parseInt(br.readLine());

            int apt[][] = new int[k+1][n+2];

            // 0층부터 k층까지 1호에는 1명만 산다
            for(int i = 0; i <= k; i++){
                apt[i][1] = 1;
            }
            // 0층의 1호부터 n호까지는 각 호수만큼 산다
            for(int i = 1; i <= n; i++){
                apt[0][i] = i;
            }

            // i층의 j호에 사는 사람의 수를 구한다. 1층부터 시작하고 호수는 2호부터 시작한다.
            for(int i = 1; i <= k; i++){
                for(int j = 2; j <= n; j++){
                    apt[i][j] = apt[i][j-1] + apt[i-1][j]; // i층의 j호
                }
            }

//            for(int i = 0; i <= k; i++){
//                for(int j = 1; j <= n; j++){
//                    System.out.print(apt[i][j] + " ");
//                }
//                System.out.println();
//            }
            System.out.println(apt[k][n]);
        }


    }
}