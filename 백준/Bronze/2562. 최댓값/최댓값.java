import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		int[] num_arr;
		int Max = 0;
		int maxIndex = 0;
		num_arr = new int[9];
		for(int i = 0; i<9; i++) {
			num_arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i<num_arr.length; i++) {
			if(num_arr[i] >= Max) {
				Max = num_arr[i];
				maxIndex = i;
			}
		}
		System.out.println(Max);
		System.out.println(maxIndex+1);
	}
}

