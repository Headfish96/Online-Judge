import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x = sc.nextInt();
        long n = 1;
        while(true){
            n++;
            if(x == 1){
                System.out.println(1);
                break;
            }
            else {
                long min = 3*(n-1)*(n-1-1)+1+1;
                long max = 3*n*(n-1)+1;
//                System.out.println(min);
                if(min <= x && x <= max){
                    System.out.println(n);
                    break;
                }
            }
        }
    }
}