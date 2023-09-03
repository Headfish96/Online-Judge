import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        // 산술평균 구하기
        double sum = 0;
        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            arr[i] = num;
            sum += num;
        }
        System.out.println((int)Math.round(sum/arr.length));

        // 정렬
        Arrays.sort(arr);

        // 중앙값 구하기
        int meidan = arr[arr.length/2];
        System.out.println(meidan);

        /**
         * 최빈값 구하기
         * 최빈값이 여러개라면 최빈값 중 두 번째로 작은 값을 출력
         * 최빈값이란 가장 많은 빈도수를 가지는 수
         * 따라서 최빈값 중 두번째로 작은 값이란
         * 가장 많은 빈도수를 가지는 수들 중에서 오름차순로 정렬하고 그 중에 두번째에 있는 값을 의미
         */

        int[] mode = new int[N];
        for(int i = 0; i < arr.length; i++){
            mode[i] = 1;
            int value = arr[i];
            int jump = 0;
            for(int j = i + 1; j < arr.length; j++){
                if(value != arr[j]){
                    break;
                }
                else {
                    jump++;
                }
            }
            mode[i] += jump;
            i += jump;
        }

        int max = 0;
        for(int i = 0; i < mode.length; i++){
            if(max <= mode[i]) max = mode[i];
        }

        int count = 0;
        for(int i = 0; i < mode.length; i++){
            if(max == mode[i]) count++;
        }

        if(count == 1){
            for(int i = 0; i < mode.length; i++){
                if(max == mode[i]){
                    System.out.println(arr[i]);
                    break;
                }

            }
        } else {
            int num = 0;
            for (int i = 0; i < mode.length; i++) {
                if (mode[i] == max) {
                    num++;
                }
                if(num == 2){
                    System.out.println(arr[i]);
                    break;
                }
            }
        }

        /** 범위 구하기 */
        int range = arr[arr.length-1] - arr[0];
        System.out.println(range);
    }

}