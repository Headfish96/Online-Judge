import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int dis = A - B;
        // 일단 나무 막대의 길이에서 A를 뺀다.
        // 그렇게 A를 뺀 남은 만큼얼마나 걸리는지 구하고 하루를 더하면 정답니다.

        if(V == A) System.out.println(1);
        else if( (V-A) % (A-B) == 0){
            System.out.println((V-A) / (A-B) + 1);
        } else {
            System.out.println((V-A) / (A-B) + 2);
        }
    }
}