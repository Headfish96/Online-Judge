import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true){
            String p = br.readLine();

            int pelin = Integer.parseInt(p);
            if(pelin == 0) break;
            int[] arr = new int[p.length()];
            for(int i = 0; i < arr.length; i++){
                arr[i] = pelin / (int) Math.pow(10,arr.length-i-1);
                pelin = pelin % (int) Math.pow(10,arr.length-i-1);
            }

            boolean flag = true;
            for(int i = 0; i < arr.length/2; i++){
                if(arr[i] == arr[arr.length - i - 1]){
                    flag = true;
                }
                else {
                    flag = false;
                    break;
                }
            }
            if(flag == true) System.out.println("yes");
            else System.out.println("no");
        }
    }
}