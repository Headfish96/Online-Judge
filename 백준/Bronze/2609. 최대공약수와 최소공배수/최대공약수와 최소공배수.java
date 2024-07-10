import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = Math.max(a, b);
        int min = Math.min(a, b);

        int LCM = 0; // 최소공배수
        int GCD = 0; // 최대공약수

        for(int i = min; i >= 1; i--){
            if(a % i == 0 && b % i == 0){
                GCD = i;
                break;
            }
        }

        for(int i = max; i <= Integer.MAX_VALUE; i++){
            if(i % a == 0 && i % b == 0){
                LCM = i;
                break;
            }
        }
        System.out.println(GCD);
        System.out.println(LCM);
    }
}