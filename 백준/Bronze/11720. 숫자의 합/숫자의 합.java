import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        String numbers = br.readLine();
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += num[i];
        }
        System.out.println(sum);
    }
}