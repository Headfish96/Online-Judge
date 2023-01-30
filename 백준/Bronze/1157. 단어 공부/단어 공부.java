
import java.util.Scanner;


public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		String[] alpha = word.split("");

		int[] num = new int[alpha.length];  
		char[] c = new char[alpha.length];
		
		for(int i = 0; i < alpha.length; i++) {
			char ch = alpha[i].charAt(0);
			num[i] = (int)ch;
		}
		
		for(int i = 0; i < num.length; i++) {
			if(num[i] > 90) {
				num[i] = num[i] - 32 - 65;
			}
			else
				num[i] = num[i] - 65;
		}
		
		int[] cnt = new int[26];
		
		for(int i = 0; i < num.length; i++) {
			cnt[num[i]]++; //cnt의 인덱스 값이 문자이고 cnt[i]는 i+65 문자의 횟수를 나타내는 것이다.
		}
		
		int max = -1;
		char answer = '?';
		for(int i = 0; i < cnt.length; i++) {
			if(max < cnt[i]) {
				max = cnt[i];
				answer = (char)(i+65);
			}
			else if(max == cnt[i])
				answer = '?';
		}
		System.out.println(answer);
	}
}
