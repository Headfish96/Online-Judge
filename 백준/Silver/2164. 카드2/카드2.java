import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Queue<Integer> q = new ArrayDeque<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			q.offer(i+1);
		}
		while(q.size()!=1) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.poll());
	}
}