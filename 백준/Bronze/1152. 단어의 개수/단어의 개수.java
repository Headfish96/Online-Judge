import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		//System.out.println(sentence);
		String[] arr = sentence.split(" ");
		
		int howlong = 0;
		
		for(int i = 0; i < arr.length; i++)
			if(!arr[i].isEmpty())
				howlong++;
		System.out.println(howlong);
	}
}
