import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arrN = new int[N];
        for(int i = 0 ; i < N; i++) arrN[i] = sc.nextInt();

        Arrays.sort(arrN);

        int M = sc.nextInt();

        for(int i = 0; i < M; i++){
            if(binarySearch(arrN, sc.nextInt()) >= 0) System.out.println(1);
            else System.out.println(0);
        }
    }

    // 정렬된 arr 배열과 찾고자 하는 key 값이 들어온다.
    public static int binarySearch(int[] arr, int key) {
        int lo  = 0;
        int hi = arr.length - 1;


        // 최조에 lo는 0이고 hi는 arr.length-1 이다.
        // mid 는 lo + hi / 2 이다.

        while(lo <= hi){

            int mid = (lo + hi)/2;

            // 그럼 여기서 key 값이 arr[mid] 보다 크다면 Up인거고
            // lo는 mid가 되고 기존 mid는 새로 구한다.
            if(key < arr[mid]){
                hi = mid - 1;
            }
            // 그럼 여기서 key 값이 arr[mid] 보다 작다면 Down인거고
            // hi는 mid -1이 되고 기존 mid는 새로 구한다.
            else if (key > arr[mid]) {
                lo = mid + 1;
            }
            // 그럼 여기서 key 값이 arr[mid] 와 같다면 mid를 return하고
            else return mid;
        }

        // 그럼 여기서 io와 hi가 같아졌는데도 key 값이 없다면 -1을 return한다.
        return -1;
    }
}