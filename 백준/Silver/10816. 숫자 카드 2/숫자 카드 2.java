import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < card.length; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine());
        int[] key = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < key.length; i++){
            key[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < key.length; i++){
            int lowerBound = Lower(card, key[i]);
            int upperBound = Upper(card, key[i]);
//            System.out.println(upperBound - lowerBound);
            sb.append(upperBound - lowerBound).append(" ");
        }
        System.out.println(sb);
    }

    public static int Lower(int[] card, int key){
        int low = 0;
        int high = card.length;

        while (low < high){
            int mid = (low + high) / 2;

            // key 값이 중간값보다 작거나 같다면
            if(key <= card[mid]){
                // 상한 값을 낮춘다.
                // lower bound를 구하는 과정이기에 key 값과 중간값이 같아도 상한 값을 낮춘다.
                high = mid;
            }
            // key 값이 중간값보다 크다면
            else {
                // 하한 값을 올린다.
                low = mid + 1;
            }
        }
        return low;
    }

    public static int Upper(int[] card, int key){
        int low = 0;
        int high = card.length;

        while (low < high){
            int mid = (low + high) / 2;

            // key 값이 중간값보다 작거나 같다면
            if(key < card[mid]){
                // 상한 값을 낮춘다.
                high = mid;
            }
            // key 값이 중간값보다 크다면
            else {
                // 하한 값을 올린다.
                // upper bound를 구하는 과정이기에 key 값과 중간값이 같아도 하한 값을 올린다.
                low = mid + 1;
            }
        }
        return high;
    }
}