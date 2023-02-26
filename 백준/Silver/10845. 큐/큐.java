import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if(order.equals("push")) q.offer(Integer.parseInt(st.nextToken()));
			
			else if(order.equals("pop")) {
				if(q.isEmpty()) sb.append(-1 + "\n");
				else sb.append(q.poll() + "\n");
			}
			
			else if(order.equals("size")) sb.append(q.size() + "\n");
			
			else if(order.equals("empty")) {
				if(q.isEmpty()) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			}
			
			else if(order.equals("front")) {
				if(q.isEmpty()) sb.append(-1 + "\n");
				else sb.append(q.peek() + "\n");
				
			}else if(order.equals("back")) {
				if(q.isEmpty()) sb.append(-1 + "\n");
				else sb.append(q.peekLast() + "\n");
			}
			
			
		}
		System.out.println(sb);
		
	}
	
}