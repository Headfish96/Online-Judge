import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();
	        int[] numbers = new int[N];
	        int cnt = 0;
	        for(int i = 0; i < N; i ++) {
	        	numbers[i] = sc.nextInt();
	        }
	        for(int i = 0; i < N; i++) {
	        	if(is_Prime(numbers[i])) cnt++;
	        	
	        }
	        System.out.println(cnt);
	 }
	 static boolean is_Prime(int number) {
		 if(number == 1) return false;
		 for(int i = 2; i <= Math.sqrt(number); i++) if(number%i == 0) return false;
		 return true;
	 }
}