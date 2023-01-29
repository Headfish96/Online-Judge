import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		int current_H = sc.nextInt();
		int current_M = sc.nextInt();
		
		int currentTime = 0;
		int wakeupTime = 0;
		int wake_H = 0;
		int wake_M = 0;
		
		currentTime = current_H*60 + current_M;
		wakeupTime = currentTime - 45;
		
		if(wakeupTime < 0) {
			wakeupTime = 24*60 + wakeupTime;
		}
		wake_H = wakeupTime / 60;
		wake_M = wakeupTime%60;
		
		System.out.println(wake_H + " " + wake_M);
		
		/*
		 * 1시간은 60
		 */
	}
}

