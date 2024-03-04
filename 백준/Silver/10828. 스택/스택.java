import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if ("push".equals(order)){
                stack.push(Integer.parseInt(st.nextToken()));
            } else if("pop".equals(order)){
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
            } else if ("size".equals(order)) {
                sb.append(stack.size()).append('\n');
            } else if ("empty".equals(order)) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
            } else {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
           }
        }

        System.out.println(sb);
    }
}