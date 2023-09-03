import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt(); // 이미 가지고 있는 랜선의 수
        int N = sc.nextInt(); // 필요한 핸선의 개수

        long[] lan = new long[K];
        long sum = 0;
        for(int i = 0; i < K; i++){
            lan[i] = sc.nextInt();
            sum += lan[i];
        }

        long ideal = sum/N;

        long left = 1;
        long right = ideal;

        while (left <= right){
            int count = 0;
            long mid = (left+right)/2;
            for(int i = 0; i < K; i++){
                count += lan[i] / mid;
            }
            if(count >= N){
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
        }
        System.out.println(right);
    }
}