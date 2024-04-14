import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int N = Integer.parseInt(br.readLine());
        int count = (int)Math.log10((double)N) + 1;
        int result = 0;
        for(int i = N - count*9; i < N; i++){
            int cnt = (int)Math.log10((double)i) + 1;
            int temp = 0;
            for(int j = 1; j <= cnt; j++){
                temp += (i%((int)Math.pow(10, j))) / (int)Math.pow(10, j-1);
            }
            temp += i;
            if (temp == N){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}