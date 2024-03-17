import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] howBig = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            howBig[i][0] = Integer.parseInt(st.nextToken());
            howBig[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            int rank = 0;
            int weight = howBig[i][0];
            int height = howBig[i][1];
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                else {
                    if(weight < howBig[j][0] && height < howBig[j][1]){
                        rank++;
                    }
                }
            }
            sb.append(rank+1).append(" ");
        }
        System.out.println(sb);
    }
}