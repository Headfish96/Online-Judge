import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        int max = Integer.MIN_VALUE;
        int maxNum = 0;

        for(int i = 0 ; i < 9; i++){
            int temp = Integer.parseInt(br.readLine());
            if(max < temp){
                max = temp;
                maxNum = i+1;
            }
        }
        sb.append(max).append("\n").append(maxNum);
        System.out.println(sb);
    }
}