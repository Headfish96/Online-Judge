import java.util.Stack;

class Solution {
    Stack<Character> stack = new Stack<>();
    boolean solution(String s) {
        boolean answer = true;
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            if(a == '('){
                stack.push(a);
            } else if(!stack.isEmpty() && a == ')') {
                stack.pop();
            } else {
                answer = false;
            }
        }
        if(stack.isEmpty() && answer == true) answer = true;
        else answer = false;
        return answer;
    }
}