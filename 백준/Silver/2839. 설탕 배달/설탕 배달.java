import java.util.Scanner;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 그리디한 접근으로 완탐을 돌릴 것임.
        int N = sc.nextInt();
        int bag = -1;

        // 5kg 봉지를 최대한 많이 쓴 것부터 시작
        // i는 5kg 봉지의 개수

        // 5kg 봉지의 개수를 하나씩 줄여나간다.
        for(int i = N/5; i >= 0; --i) {
            // N이 5로 나뉘어 떨어지는 경우
            if (5 * i == N) {
                bag = i;
                break; // 정답을 찾았으니 반복문 종료
            }
            // N이 5로 나뉘지 않아서 i가 하나 줄어든 경우
            else {
                // 그 나머지가 3으로 나누어지지 않는다면 또 하나 줄어들어야 함.
                if ((N - 5 * i) % 3 != 0) {
                    continue;
                }
                // 그 나머지가 3으로 나누어지면 이게 정답
                else {
                    bag = (N - 5 * i) / 3 + i;
                    break; // 정답을 찾았으니 반복문 종료
                }
            }
        }
        System.out.println(bag);
    }
}