import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            // 하나의 숫자에 대해서 lower_bound와 upper_bound를 구해서 차를 출력해야한다.
            int key = sc.nextInt();
            // lower_bound를 먼저 구한다.
            int low_bottom = 0, up_bottom = 0; // 시작 bottom은 0인덱스
            int low_top = N, up_top = N; // 시작 top은 N인덱스

            while (low_bottom != low_top){ //bottom과 top 두 인덱스가 같아질때까지 반복
                int low_mid = (low_bottom + low_top) / 2; // 두 인덱스의 중간 인덱스
                if(key <= A[low_mid]) { // 찾고자하는 수가 중간 인덱스의 값보다 작을때, 즉, key < A[mid] < A[top]일때
                    low_top = low_mid; // lower_bound를 구하기 위한 것이니, top을 mid로 줄인다.
                }
                else if (key > A[low_mid]){ // 찾고자하는 수가 중간 인덱스의 값보다 클때, 즉, A[bottom] < A[mid] < key
                    low_bottom = low_mid + 1;
                }
            }

            // 그 다음 uppper_bound를 구한다.
            while (up_bottom != up_top){
                int up_mid = (up_bottom + up_top) / 2;
                if(key < A[up_mid]) { // 찾고자하는 수가 중간 인덱스의 값보다 작을때, 즉, key < A[mid] < A[top]일때
                    up_top = up_mid;// upper_bound를 구하기 위한 것이니, top을 mid로 줄인다.
                }
                else if(key >= A[up_mid]) { // 찾고자하는 수가 중간 인덱스의 값보다 클때, 즉, A[bottom] < A[mid] < key
                    up_bottom = up_mid + 1;// up_bottom을 mid+1로 늘려준다.
                }
            }
            sb.append(up_top - low_bottom).append(' ');
        }
        System.out.println(sb);
    }
}