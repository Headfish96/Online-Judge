import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) deque.addLast(i);

        while (deque.size() > 1){
//            System.out.println("버릴 수: " + deque.peekFirst());
            deque.pollFirst(); // 버림

//            System.out.println("뒤에다가 넣을 현재 맨 앞에 있는 수: " + deque.peekFirst());
            int a = deque.pollFirst();
            deque.addLast(a);
        }
        System.out.println(deque.peek());
    }
}