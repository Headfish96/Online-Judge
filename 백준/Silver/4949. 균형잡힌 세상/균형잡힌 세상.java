import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        String s;

        while (true) {
            s = br.readLine();
            if(s.equals(".")) break;
            sb.append(solve(s)).append("\n");
        }
        System.out.println(sb);
    }

    public static String solve(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '['){
                stack.push(c);
            } else if(c == ')'){
               if(stack.isEmpty()){
                   return "no";
               } else if(stack.peek() == '('){
                   stack.pop();
               } else {
                   return "no";
               }
            } else if (c == ']') {
                if(stack.isEmpty()){
                    return "no";
                } else if(stack.peek() == '['){
                    stack.pop();
                } else {
                    return "no";
                }
            }
        }
        if(stack.isEmpty()) return "yes";
        else return "no";
    }
}