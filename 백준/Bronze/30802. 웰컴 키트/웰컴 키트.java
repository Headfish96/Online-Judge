import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);


        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] size = new int[6];
        for(int i = 0; i < size.length; i++){
            size[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st2.nextToken());
        int P = Integer.parseInt(st2.nextToken());


        int Tshirts = 0;
        for(int i = 0; i < size.length; i++){
            Tshirts = Tshirts + (size[i] / T);
            if(size[i] % T != 0){
                ++Tshirts;
            }
        }

        int Pen = N / P;
        int leftOver = N % P;

        System.out.println(Tshirts);
        System.out.println(Pen + " " + leftOver);


        // 티셔츠를 T장씩 몇 묶음을 주문해야하는지는 각 사이즈의 손님들의 수를 T장으로 나누었을때의 몫과 나머지가 있다면 몫에 1을 더하면 된다.

        // 펜을 몇 묶음 주문할 수 있는지는 손님의 수를 P로 나눈 몫이고, 나머지가 한 자루씩 몇 개 주문하는가 이다.



    }
}