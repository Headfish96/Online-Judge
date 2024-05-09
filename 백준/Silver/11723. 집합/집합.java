import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println("HelloWorld");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();


        int M = Integer.parseInt(br.readLine());
        int[] zip = new int[21];
        int num = 0;
        for(int i = 0; i < zip.length; i++) zip[i] = 0;
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order){
                case "add" :
                    num = Integer.parseInt(st.nextToken());
                    if(zip[num] != 0) break;
                    else zip[num] = num;
                    break;
                case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    if(zip[num] == 0) break;
                    else zip[num] = 0;
                    break;
                case "check" :
                    num = Integer.parseInt(st.nextToken());
                    if(zip[num] == num) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "toggle" :
                    num = Integer.parseInt(st.nextToken());
                    if(zip[num] == num) zip[num] = 0;
                    else zip[num] = num;
                    break;
                case "all" :
                    for(int j = 1; j <= 20; j++) zip[j] = j;
                    break;
                case "empty" :
                    for(int j = 1; j <= 20; j++) zip[j] = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}