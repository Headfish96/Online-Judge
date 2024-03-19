import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n];
        for(int i = 0; i < n; i++) level[i] = Integer.parseInt(br.readLine());
        Arrays.sort(level);

        // 문제의 난이도는 모든 사람의 난이도 의견의 30%를 절사평균으로 정한다.
        int exceptNum = (int) Math.round(n*0.15);
//        System.out.println("위에서 절삭해야하는 명수: " + exceptNum);
//        System.out.println("아래에서 절삭해야하는 명수: " + exceptNum);
        double sum = 0;
        for(int i = exceptNum; i < n-exceptNum; i++){
//            System.out.println(i+1 + " 번째 값은: " + level[i]);
            sum += (double)level[i];
        }
//        System.out.println("절삭하고 남은 값들의 합: " + sum);
//        System.out.println("절삭하고 남은 수의 개수: " + (n-exceptNum*2));
        double x = sum/(n-exceptNum*2);
//        System.out.println(x);
        System.out.println(Math.round(x));

        /**
         * 1 3 12 12 13 13 14 15 15 16
         * 10명이 투포했다면 15%는 10%면
         */
    }
}