import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numList = new int[N]; // 입력되는 정수의 리스트
        for (int i = 0; i < N; i++) numList[i] = Integer.parseInt(br.readLine()); // 정수를 입력받는다.
        Arrays.sort(numList); // 오름차순으로 정렬한다.

//        System.out.println(arithmeticMean(numList));
//        System.out.println(median(numList));
//        System.out.println(mode(numList));
//        System.out.println(range(numList));
        sb.append(arithmeticMean(numList)).append("\n").append(median(numList)).append("\n").append(mode(numList)).append("\n").append(range(numList));
        System.out.println(sb);
    }

    public static int arithmeticMean(int[] numList) {
        double sum = 0;
        for(int i = 0; i < numList.length; i++) sum += numList[i];
//        System.out.println(sum/numList.length);
        return (int)Math.round(sum/numList.length);
    }

    public static int median(int[] numList) {
        return numList[numList.length/2];
    }

    public static int range(int[] numList) {
        return numList[numList.length-1] - numList[0];
    }

    public static int mode(int[] numList) {
        int mode = 0;
        ArrayList<int[]> arrayList = new ArrayList<>(); // {값, 빈도수}를 저장하는 ArrayList 선언해준다.
        int benchMark = 0; // 기준값 선언
        while (true) { // 무한반복
            int count = 1; // 빈도는 최초에 1로 시작한다.
            for (int i = benchMark + 1; i < numList.length; i++) { // 기준점 다음것 부터 끝까지 비교한다.
                if (numList[benchMark] == numList[i]) count++; // 같다면 count를 증가시킨다.
                else break; // 다르면 뒤에는 더 비교할 필요가 없다.
            }
            int[] temp = new int[2]; // ArrayList에 들어가는 {값, 빈도수}를 넣을 배열
            temp[0] = numList[benchMark]; // 현재 비교를 시작한 기준값
            temp[1] = count; // 현재 기준값의 빈도수
            arrayList.add(temp); // {값, 빈도수}를 ArrayList에 저장한다.
            benchMark = benchMark + count; // 기준값을 다른 수로 갱신한다.
            if (benchMark == numList.length) { // 만약에 뒤에가 더 비교가 필요 없는 경우 나간다.
                break;
            }
        }

        for(int i = 0; i < arrayList.size(); i++){
//            System.out.println("값: " + arrayList.get(i)[0] + ", 빈도수:" + arrayList.get(i)[1]);
        }

        int max = 0; // 최빈값의 빈도를 저장할 변수 선언
        for(int i = 0; i < arrayList.size(); i++){
            if(max <= arrayList.get(i)[1]) max = arrayList.get(i)[1]; // max를 구한다.
        }
//        System.out.println("최빈값의 빈도: " + max);

        ArrayList<int[]> modeList = new ArrayList<>(); // {값, 빈도수}를 저장하는 ArrayList 선언해준다.
        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i)[1] == max){
                int[] temp = new int[2];
                temp[0] = arrayList.get(i)[0];
                temp[1] = arrayList.get(i)[1];
                modeList.add(temp);
            }
        }

        for(int i = 0; i < modeList.size(); i++){
//            System.out.println("값: " + modeList.get(i)[0] + ", 빈도수:" + modeList.get(i)[1]);
        }

        if(modeList.size() == 1){
            mode = modeList.get(0)[0];
        } else mode = modeList.get(1)[0];

        // 최빈값의 빈도를 구했을 때 가장 작은 최빈값을 보고 나서 가장 작은 최빈값보다 한 단계 더 큰 값의 빈도를 확인한다.
        // 한 단계 더 큰 값의 빈도가 최빈값의 빈도와 같다면 한 단계 더 큰 값의 빈도가 정답이다.
        // 그렇지 않다면 가장 작은 최빈값이 정답니다.
//        for(int i = 0; i < arrayList.size(); i++){
//            if(arrayList.get(i)[1] == max){ // 값의 빈도수가 최빈값의 빈도수와 같은지 확인한다.
//                System.out.println("값의 빈도 수가 최빈밧의 빈도수와 같다.");
//                if(i == arrayList.size() -1){ // 만약 값의 빈도수가 최빈값의 빈도수와 같은데, 한 단계 더 큰 값이 없는 경우
//                    System.out.println("값의 빈도수가 최빈값의 빈도수와 같은데, 마지막 값이다.");
//                    mode = arrayList.get(i)[0]; // 최빈값은 현재 값이다.
//                    break;
//                } else { // 만약 값의 빈도수가 최빈값의 빈도수와 같고, 한 단계 더 큰 값이 있는 경우
//                    System.out.println("값의 빈도수가 최빈값의 빈도수와 같은데, 더 큰 값이 존재한다.");
//                    if(arrayList.get(i+1)[1] == max){ // 만약 값의 빈도수가 최빈값의 빈도수와 같고, 한 단계 더 큰 값의 빈도수도 최빈값의 빈도 수와 같다면
//                        mode = arrayList.get(i+1)[0]; // 최빈값 중 두 번째로 작은 값이 정답이다.
//                        break;
//                    } else { // 만약 값의 빈도수가 최빈값의 빈도수와 같고, 한 단계 더 큰 값의 빈도수가 최빈값의 빈도 수와 같지 않다면
//                        mode = arrayList.get(i)[0]; // 최빈값은 현재 값이다.
//                    }
//                }
//            }
//        }
        return mode;
    }
}