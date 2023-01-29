
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char C = sc.next().charAt(0); //여기서 0은 몇번째 글자를 전환할 것인지 인덱스임
		//System.out.println(C);
		int char_to_num = (int)C;
		System.out.println(char_to_num);
	}
}
