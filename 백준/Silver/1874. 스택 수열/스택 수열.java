import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("hello world");

        Stack<Integer> stack = new Stack<>();
        Queue<String> pm = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numbers = new int[n];

        for(int i = 0; i < n; i++){
            numbers[i] = sc.nextInt();
        }

        int count = 0;
        int num = 1;
        while (count != n && num <= n+1) {
            if(stack.isEmpty()){
                stack.add(num);
                pm.add("+");
                num++;
            }
            else if(!stack.isEmpty() && stack.peek() == numbers[count]){
                stack.pop();
                pm.add("-");
                count++;
            }
            else if(!stack.isEmpty() && stack.peek() != numbers[count]){
                stack.add(num);
                pm.add("+");
                num++;
            }
        }
        if(!stack.isEmpty()){
            System.out.println("NO");
        } else {
            while (!pm.isEmpty()){
                System.out.println(pm.poll());
            }
        }
    }
}