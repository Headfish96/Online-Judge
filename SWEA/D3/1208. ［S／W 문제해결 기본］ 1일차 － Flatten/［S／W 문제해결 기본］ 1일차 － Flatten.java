

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int t;
	static int N;
	static int[] boxheights;
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("src/data/sw-input1208.txt"));
		Scanner sc = new Scanner(System.in);
		for(t = 1; t <= 10; t++) {
			int N = sc.nextInt(); // dump 가능한 횟수 N
			boxheights = new int[100];
			//각 상자의 높이가 저장되어 있는 배열 boxheignt 선언
			//따라서 각 상자의 인덱스가 상자 번호가 되고 boxheight가 그 상자의 높이가 된다.
			for(int i = 0; i < 100; i++) {
				boxheights[i] = sc.nextInt();
			} // 사용자로부터 상자 100개의 높이를 받아온다.
			dump(N);
		}
	}
	
	private static void dump(int cnt) { // 사용자로부터 받아온 dump 가능한 횟수 cnt
		int MIN = 100; // 상자를 전부 돌면서 최저 높이를 저장할 변수 MIN
		int MAX = 0; // 상자를 전부 돌면서 최고 높이를 저장할 변수 MAX
		int minIndex = 0; // 최저 높이의 상자의 인덱스를 저장할 변수 minIndex
		int maxIndex = 0; // 최고 높이의 상자의 인덱스를 저장할 변수 maxIndex
			
		for(int i = 0; i < cnt; i++) { // dump 가능한 횟수 내에서 
			for(int j = 0; j < 100; j++) { // 상자의 높이를 전부 보면서
				if(MIN >= boxheights[j]) {
					MIN = boxheights[j]; // 최저 높이를 MIN에 저장
					minIndex = j; // 그 최저 높이의 인덱스를 minIndex에 저장
				}
				if(MAX <= boxheights[j]) {
					MAX = boxheights[j]; // 최고 높이를 MAX에 저장
					maxIndex = j; // 그 최고 높이의 인덱스를 maxIndex에 저장
				}
			}
			
			MAX = MAX - 1;
			MIN = MIN + 1;
			boxheights[maxIndex] = boxheights[maxIndex] - 1; //최고 높이의 인덱스를 갖는 값, 즉 최고 높이에서 1을 뺀다.
			boxheights[minIndex] = boxheights[minIndex] + 1; //최저 높이의 인덱스를 갖는 값, 즉 최저 높이에서 1을 더해준다.
			
			for(int j = 0; j < 100; j++) { // 상자의 높이를 전부 보면서
				if(MIN >= boxheights[j]) {
					MIN = boxheights[j]; // 최저 높이를 MIN에 저장
					minIndex = j; // 그 최저 높이의 인덱스를 minIndex에 저장
				}
				if(MAX <= boxheights[j]) {
					MAX = boxheights[j]; // 최고 높이를 MAX에 저장
					maxIndex = j; // 그 최고 높이의 인덱스를 maxIndex에 저장
				}
			}
			
			if((MAX - MIN) <= 1) {
				System.out.println(boxheights[maxIndex] - boxheights[minIndex]);
				break;
			}
		}
		//System.out.println(boxheights[maxIndex] - boxheights[minIndex]);
		System.out.println("#" + t + " " + (MAX - MIN));
	}
}
