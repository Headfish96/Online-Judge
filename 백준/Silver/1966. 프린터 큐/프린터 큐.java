import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("helloworlds");

        /**
         * 조건이 주어질때 그 큐에서 해당 원소의 위치가 값이고 중요도를 비교한다고 생각한다.
         * 예를 들어서 6 0 으로 주어져서 6개 문서 중에 큐에서 현재 0번째의 위치에 있는 문서가
         * 실재로는 몇번째로 출력이 되는지를 생각했을때
         * 0번이라는건 값으로 생각하면 되고 결국 0의 값을 갖고 중요도는 1인 원소가 몇번째로 출력되는지를 알면 된다.
         * 그러면 먼저 테스트케이스가 하나만 있다고 생각했을때 큐에 집어 넣고 값을 확인하는 것 부터 시작해보자.
         */

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수
        for(int t = 0; t < T; t++){
            int N = sc.nextInt(); // 문서의 개수
            int M = sc.nextInt(); // 몇번째로 인쇄되는지 알고 싶은 문서의 위치(값)
            int count = 0;
            LinkedList<int[]> queue = new LinkedList<>();
            for(int i = 0; i < N; i++){
                queue.add(new int[] {i, sc.nextInt()}); // int 배열 형태의 하나의 배열을 큐에 넣을 것임
                // (위치, 중요도) 형태로 들어간다.
            }

//            for(int i = 0; i < N; i++){
//                System.out.println("위치: " + queue.get(i)[0] + ", 중요도: " + queue.get(i)[1]); // 큐에 들어있는 해당 원소의 중요도만을 출력한다.
//            }

            // 그럼 이제 큐에서 가장 앞에 있는 원소를 뽑고, 해당 원소의 중요도를 출력한다.
            boolean flag = true;
            while (flag){
                int[] front = queue.poll(); // 큐에서 가장 앞에 있는 원소를 뽑는다.
//                System.out.println("뽑은 원소의 위치: " + front[0] + ", 중요도: " + front[1]);
                int a = 0;
                for(int i = 0; i < queue.size(); i++) { // 나머지 큐에 들어있는 원소만큼 비교한다.
                    a++;
                    if (front[1] < queue.get(i)[1]) { // 뭐를? 중요도를 비교한다.
                        queue.add(front); // 중요도가 더 높은게 큐에 남아있었으면 큐의 맨 마지막에 넣어준다.
//                        System.out.println("중요도가 더 높은게 남아있음");
                        break;
                    }
                }
                // 큐의 사이즈와 같다는건 중요도가 더 높은게 없었다는 의미.
                if(a == queue.size()) {
//                    System.out.println("중요도 더 높은게 없음");
//                    System.out.println("출력되는 원소 => 중요도: " + front[1] + "값: " + front[0]);
                    count++; // 출력하고 카운트 값을 올려준다.
                    if(front[0] == M){
                        System.out.println(count); // 만약 출력된 원소의 값이 내가 원하는거면 count 값 출력
                        flag = false;
                    }
                }
            }
        }
    }
}