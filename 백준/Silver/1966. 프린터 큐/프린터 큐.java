import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<int[]> listWithCard = new ArrayList<>(); // 인쇄 대기열(문서의 번호와 문서의 중요도가 들어있음)

            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 몇번째로 인쇄되는지 알고 싶은 문서의 번호(0부터 시작)

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                int[] importantWithCard =  new int[2];
                importantWithCard[0] = j;
                importantWithCard[1] = Integer.parseInt(st2.nextToken());
                listWithCard.add(importantWithCard); // 인쇄 대기열에 초기값 추가
            }
            System.out.println(checkPrintNum(M, listWithCard));
        }
    }
    public static int checkPrintNum(int M, ArrayList<int[]> listWithCard) {
        // 현재 구하고자 하는 문서의 번호 M;
        // 문서들의 초기 배치 상태(값은 중요도) 0번부터 시작 listWithCard
        int printCount = 0; // 몇번째 인쇄인지 구하고자 하는 변수 printCount
//        System.out.println("문서들을 가지고 있는 listWithCard의 크기" + listWithCard.size());
        int N = listWithCard.size();
        while(true){
            for(int i = 0; i < listWithCard.size(); i++){
//                System.out.println("인쇄 대기열의 " + i + "번째 문서의 번호: " + listWithCard.get(i)[0] + ", 문서의 중요도: " + listWithCard.get(i)[1]);
            }

            int count = 0;

            for(int i = 1; i < listWithCard.size(); i++){
                if(listWithCard.get(0)[1] < listWithCard.get(i)[1]) {
//                    System.out.println("가장 앞에 있는 문서의 중요도 보다 중요도가 높다.");
                } else {
//                    System.out.println("가장 앞에 있는 문서의 중요도가 더 높거나 같다.");
                    count++;
                }
            }

            if(count == listWithCard.size()-1){
//                System.out.println("가장 앞에 있는 문서의 중요도가 가장 높아서 인쇄한다.");
                printCount++;
                if(listWithCard.get(0)[0] == M){
                    return printCount;
                }
                listWithCard.remove(0);
            }
            else{
//                System.out.println("가장 앞에 있는 문서의 중요도가 가장 높지 않아, 대기열의 맨 뒤로 옮긴다.");
                int[] temp = {listWithCard.get(0)[0], listWithCard.get(0)[1]};
                listWithCard.remove(0);
                listWithCard.add(temp);
            }
        }
    }
}