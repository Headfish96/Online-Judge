import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int r = 31;
        int M = 1234567891;
        int[] word = new int[L];
        int H = 0;
        for(int i = 0; i < L; i++){
            word[i] = (int)str.charAt(i) - 96;
            H += word[i]*Math.pow(31, i);
        }
        H = H % M;
        System.out.println(H);
    }
}