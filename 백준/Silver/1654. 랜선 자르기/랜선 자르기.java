import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 오영식이 가지고 있는 랜선의 개수 K
        int K = Integer.parseInt(st.nextToken());
        // 박성원이 원하는 랜선의 개수 N
        int N = Integer.parseInt(st.nextToken());
        // 오영식이 가지고 있는 랜선들의 길이를 저장하는 배열 lan 선언
        int[] lan = new int[K];
        // 랜선들의 길이를 저장하는 배열 lan에 오영식이 가지고 있는 랜선들의 길이를 집어 넣음.
        for(int i = 0; i < lan.length; i++){
            lan[i] = Integer.parseInt(br.readLine());
        }
        // 자를 수 있는 랜선의 최대 길이를 구하는 함수 Upper 사용
        System.out.println(Upper(lan, N));
    }

    // 자를 수 있는 랜선 길이의 최댓값을 구하는 것이니 상한값을 구해야한다.
    // 매개변수로 오영식이 가지고 있는 랜선들의 길이를 저장한 배열 lan과 박성원이 원하는 랜선의 개수 N이 주어짐
    public static long Upper(int[] lan, int N){
        // 랜선들이 길이가 저장되어 있는 배열 lan 중에 가장 큰 랜선의 길이를 저장하는 변수 max 선언
        // 랜선이 길이가 0일 수 없으니 max는 1부터 해도 된다.
        long max = 1;
        // 배열 lan을 순회하면서 가장 큰 랜선의 길이를 구해 max에 넣는다.
        for(int i = 0; i < lan.length; i++){
            // 입력값 중 제일 큰 값을 저장
            if(max < lan[i]) max = lan[i];
        }

        // 이분 탐색에서 랜선 길이의 최솟값을 나타내는 변수 min 선언 및 0으로 초기화
        long min = 1;
        long mid;

        // 이분 탐색에서 왼쪽값(최솟값)과 오른쪽값(최댓값)이 같아질때까지 반복
        while (min <= max){
            mid = (max + min)/2;
            // 중간 값으로 잘랐을때 몇개가 되는지 계산할 변수 count 선언 및 0으로 초기화.
            long count = 0;
            // 배열 lan을 순회하면서 mid의 길이만큼 잘랐을때 몇개가 생성되는지 확인.
            for(int i = 0; i < lan.length; i++){
                count += (lan[i]/mid);
            }
            // 생성된 개수가 원하는 개수 N보다 작음
            if(count < N){
                // 더 작은 크기로 잘라야 더 많은 개수가 생기니 high의 값을 줄인다.
                max = mid-1;
            }
            // 생성된 개수가 원개는 개수 N보가 크거나 같음
            else if(count >= N){
                // 더 큰 크기로 잘라도 되는지 확인해야하니 low의 값을 키운다.
                min = mid+1;
                // 만약 이렇게 해서 low와 high의 값이 같아진다면, low, mid, high는 연속된 3개의 자연수이다.
                // low를 x라고 하고 mid를 n이라 하면, x = n+1 = high 이니 high는 n+1이고, x + n + 1 = 2n 이고 따라서 x = n-1이니, n-1, n, n+1 이다.
            }
        }
        return max;
    }
}