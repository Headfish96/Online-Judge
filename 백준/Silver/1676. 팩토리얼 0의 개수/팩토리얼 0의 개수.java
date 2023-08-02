import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);

        int count = 0;

        int N = sc.nextInt();

        boolean flag = true;
        while(flag) {
           N = N/5;
           count += N;
           if(N < 5){
               flag = false;
           }
        }
        System.out.println(count);
    }
}