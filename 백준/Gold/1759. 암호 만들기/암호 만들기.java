

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L;
	static int C;
	static char[] alphabet;
	static char[] words;
	static int vowelCnt;
	static int consonantCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt(); // L개를 뽑는다.
		C = sc.nextInt(); // C개 중에서
		alphabet = new char[C]; 
		for(int i = 0; i < C; i++) {
			alphabet[i] = (sc.next()).charAt(0);
		}
		Arrays.sort(alphabet);

		words = new char[L];
		
		combChar(0,0);
	}
	
	static void combChar(int cnt, int start) {
		if(cnt ==L) {
			vowelCnt = 0;
			consonantCnt = 0;
			for(int i = 0; i < L; i++) {
				if(words[i] == 'a' || words[i] == 'e' || words[i] == 'i' || words[i] == 'o' || words[i] == 'u') {
					vowelCnt++;
				}
				else consonantCnt++;
			}
			if(vowelCnt != 0 && consonantCnt >= 2) {
				for(int i = 0; i < L; i++) {
					System.out.print(words[i]);
				}
				System.out.println();				
//				System.out.println("vowelCnt: " +  vowelCnt);
//				System.out.println("consonantCnt: " + consonantCnt);
			}
			return;
		}
		for(int i = start; i < C; i++) {
			words[cnt] = alphabet[i];
			combChar(cnt + 1, i + 1);
		}
	}
}
