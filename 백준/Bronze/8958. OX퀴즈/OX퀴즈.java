
import java.util.Scanner;


public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int j = 0; j < T; j++) {
			String ox = sc.next();
			String[] oxArr = ox.split("");
			int total = 0;
			int score = 0;
			for(int i = 0; i < oxArr.length; i++) {
				if(oxArr[i].equals("O"))
					score++;
				else
					score = 0;
			total = total + score;
			}
			System.out.println(total);	
		}
	}
}
