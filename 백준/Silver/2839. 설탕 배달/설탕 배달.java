import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if(N == 4 || N == 7){ // 3과 5 둘다 안나뉘면 -1
            System.out.println(-1);
        } else if(N%5 == 0){ // 5의 배수이면
            System.out.println(N/5); // 5의 배수가 가장 적으니까 출력
        } else if(N%5 == 1) {
            System.out.println(N/5 + 1);
        } else if(N%5 == 2){
            System.out.println(N/5 + 2);
        } else if(N%5 == 3) {
            System.out.println(N/5 + 1);
        } else if(N%5 == 4){
            System.out.println(N/5 + 2);
        }
    }
}