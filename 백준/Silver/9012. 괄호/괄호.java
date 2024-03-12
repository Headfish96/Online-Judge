import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        for(int k = 0; k < N; k++){
            Stack stack = new Stack<>();
            String ps = br.readLine();

            boolean flag = true;

            for(int i = 0; i < ps.length(); i++){
                char p = ps.charAt(i);
                if(p == '('){
                    stack.push(p);
                } else {
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }
                    else stack.pop();
                }
            }
            if(flag && stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}