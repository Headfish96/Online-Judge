import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("helloworld");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N명의 사람 중
        int K = sc.nextInt(); // K번째 사람을 제거한다.
        Queue<Integer> queue = new LinkedList<>(); // N명의 사람 큐
        Queue<Integer> yose = new LinkedList<>(); // 요세푸스 순열을 저장할 큐
        for(int i = 1; i <= N; i++){
            queue.add(i); // 큐를 만든다.
        }

        while (!queue.isEmpty()){ // 사람이 전부 제거될때까지 반복한다.
//            System.out.println("제거 큐에 남은 사람의 수: " + queue.size());
            for(int i = 1; i <= K; i++){ // K번만큼 반복한다.
                int x = queue.poll();
                if(i != K){ // K번째 사람이 아닌 경우
//                    System.out.println("다시 큐에 들어가는 수: " + x);
                    queue.add(x); // 다시 제거 큐에 집어 넣는다.
                }
                else if(i == K){ // K번째 사람인 경우
//                    System.out.println("요세푸스 큐에 들어가는 수: " + x);
                    yose.add(x); // 요세푸스 순열에 넣는다.
//                    System.out.println("요세푸스 큐의 크기: " + yose.size());
                }
            }
        }
//        System.out.println("요세푸스 큐의 크기 재확인: " + yose.size());
        System.out.print("<");
        while (!yose.isEmpty()){
            if(yose.size() == 1) System.out.print(yose.poll());
            else System.out.print(yose.poll() + ", ");
        }
        System.out.println(">");
    }
}