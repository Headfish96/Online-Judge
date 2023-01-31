import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		int[] xyz = new int[3];
		
		boolean flag = true;
	
		while(flag) {
			for(int i = 0; i < 3; i++) {
				temp = sc.nextInt();
				xyz[i] = temp*temp;
			}
			if(xyz[2] == 0) {
				flag = false;
				break;
			}
			
			Arrays.sort(xyz);
			
			if(xyz[2] == xyz[0] + xyz[1]) {
				System.out.println("right");
			}
				
			else if(xyz[2] != xyz[0] + xyz[1]) {
				System.out.println("wrong");
			}
			
			
		}
	}
}