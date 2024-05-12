import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int M = 1234567891;
        long H = 0;
        long R = 1;
        for(int i = 0; i < L; i++){
            R = R % M;
            H += (((int)str.charAt(i) - 96) % M) * (R % M) ;
            R *= 31;
        }
        H = H % M;
        System.out.println(H);
    }
}