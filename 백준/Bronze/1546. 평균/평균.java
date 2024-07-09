import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static <dobule> void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int N = Integer.parseInt(br.readLine());
        double[] score = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double Max = 0;
        for(int i = 0; i < N; i++){
            score[i] = Integer.parseInt(st.nextToken());
            if(score[i] > Max) Max = score[i];
        }
        for(int i = 0; i < N; i++){
            score[i] = score[i]/Max*100;
        }
        double sum = 0;
        for(int i = 0; i < N; i++){
            sum += score[i];
        }
        System.out.println(sum/N);
    }
}