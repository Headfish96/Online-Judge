import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int primeCount = 0;
        for(int i = 0; i < N; i++){
            int count = 0;
            for(int j = 2; j < arr[i]; j++){
                if(arr[i] % j != 0){
                    count++;
                }
            }
            if(count == arr[i] - 2) primeCount++;
        }
        System.out.println(primeCount);
    }
}