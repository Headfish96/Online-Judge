import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> deque = new LinkedList<>();
		Deque<Integer> q = new ArrayDeque<>();
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			String order = sc.next();
			if(order.equals("push_front")) {
				int a = sc.nextInt();
				deque.addFirst(a);
			}
			else if(order.equals("push_back")) {
				int a = sc.nextInt();
				deque.add(a);
			}
			else if(order.equals("pop_front")) {
				if(deque.isEmpty())sb.append(-1).append('\n');
				else sb.append(deque.pop()).append('\n');
			}
			else if(order.equals("pop_back")) {
				if(deque.isEmpty())sb.append(-1).append('\n');
				else sb.append(deque.pollLast()).append('\n');
			}
			else if(order.equals("size")) {
				sb.append(deque.size()).append('\n');
			}
			else if(order.equals("empty")) {
				if(deque.isEmpty())sb.append(1).append('\n');
				else sb.append(0).append('\n');
			}
			else if(order.equals("front")) {
				if(deque.isEmpty())sb.append(-1).append('\n');
				else sb.append(deque.peek()).append('\n');
			}
			else if(order.equals("back")) {
				if(deque.isEmpty())sb.append(-1).append('\n');
				else sb.append(deque.peekLast()).append('\n');
			}
		}
		System.out.println(sb);
	}
}