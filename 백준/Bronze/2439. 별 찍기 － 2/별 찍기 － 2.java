import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            String star = ("*").repeat(i);
            String blank = (" ").repeat(N-i);
            sb.append(blank).append(star).append("\n");
        }
        System.out.println(sb);
    }
}