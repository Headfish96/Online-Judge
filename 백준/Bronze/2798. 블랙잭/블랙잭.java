import java.util.Arrays;
    import java.util.Scanner;
/*
4 46
2 14 15 30
46

4 10
1 2 3 8
6

5 21
5 6 7 8 9
21

10 500
93 181 245 214 315 36 185 138 216 295
497
 */
    public class Main {
        static int M, min, answer, N, BlackJack, inputs[], numbers[];
        static boolean visited[];

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            N = sc.nextInt(); // 전체 카드의 수
            BlackJack = sc.nextInt(); // 카드 3장을 합했을때 나오길 원하는 숫자
            M = 3; // 뽑는 카드의 수

            inputs = new int[N]; // 주어진 카드의 정보
            numbers = new int[M]; // 뽑힌 카드의 수

            for (int i = 0; i < N; i++) inputs[i] = sc.nextInt(); // 카드의 정보를 입력받음

            min = Integer.MAX_VALUE; // 차이를 구하려는 변수 min 선언 및 초기화
            answer = 0; // 정답을 저장하는 변수 answer

            comb(0, 0);
            System.out.println(answer);
        }

        static void comb(int cnt, int start) {
            int sum = 0; // 카드의 합을 저장하는 변수
            if (cnt == M) { // 3장을 뽑았을 경우 재귀를 멈춘다.
//                System.out.println(Arrays.toString(numbers));
                for(int i = 0; i < M; i++){
                    sum += numbers[i]; // 카드의 합을 구한다.
                }
//                System.out.println("카드의 합: " + sum);
                int temp = BlackJack - sum; // 뽑힌 카드들의 합에서 원하는 수와의 차를 구한다.
                if(temp == 0){
                    answer = BlackJack; // 만약 원하는 수와 일치하면 거기서 종료한다.
//                    System.out.println("check");
                    return;
                } else if(temp > 0 && min > temp){
//                    System.out.println("temp: " + temp);
                    min = temp;
                    answer = sum;
//                    System.out.println("check here");
                }
                return;
            }

            for (int i = start; i < N; i++) {
                numbers[cnt] = inputs[i];
                if(answer == BlackJack) break;
                comb(cnt + 1, i + 1);
            }
        }

    }