import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] word = sc.next().split("");
		
		visited = new boolean[26];
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < word.length; j++) {
				if( (int)(word[j].charAt(0)) - 97 == i && visited[i] == false) {
					visited[i] = true;
					arr[i] = j; 
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			
		}
	}
}