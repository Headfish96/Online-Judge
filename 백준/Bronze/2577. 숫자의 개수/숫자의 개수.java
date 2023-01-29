import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int ABC = A*B*C;
		//System.out.println(ABC);
		String X = Integer.toString(ABC);
		String[] num = X.split("");
		//for(int i=0; i<num.length; i++)
		//	System.out.println(num[i]);
		
		int[] times = new int[10];
		
		for(int i=0; i<num.length; i++) {
			for(int j=0; j<times.length; j++) {
				if(Integer.parseInt(num[i]) == j)
					times[j]++;
			}
		}
		
		for(int i = 0; i < times.length; i++)
			System.out.println(times[i]);
				
	}
}
