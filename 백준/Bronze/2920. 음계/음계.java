import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		int[] ascendingArr = {1,2,3,4,5,6,7,8};
		int[] decendingArr = {8,7,6,5,4,3,2,1};
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		if(Arrays.equals(ascendingArr, arr))
			System.out.println("ascending");
		else if(Arrays.equals(decendingArr, arr))
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
