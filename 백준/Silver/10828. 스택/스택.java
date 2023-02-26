import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();

			if(order.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else if(order.equals("pop")) {
				if(stack.isEmpty()) sb.append(-1 + "\n");
				else sb.append(stack.pop() + "\n");
			}
			else if(order.equals("size")) sb.append(stack.size() + "\n");
			
			else if(order.equals("empty")) {
				if(stack.isEmpty()) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			}
			else if(order.equals("top")) {
				if(stack.isEmpty()) sb.append(-1 + "\n");
				else sb.append(stack.peek() + "\n");
			}
		}
		System.out.print(sb);
		
	}
}