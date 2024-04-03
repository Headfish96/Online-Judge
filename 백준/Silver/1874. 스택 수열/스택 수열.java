import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> showStack = new Stack<>();
        Stack<Integer> saveStack = new Stack<>();
        Queue<Character> printChar = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine()); // n까지의 수
        for(int i = n; i >= 1; i--) saveStack.push(i);

        boolean check = true;
        for(int i = 0; i < n; i++){
            boolean flag = true;
            int x = Integer.parseInt(br.readLine());
            while (flag){
                if(showStack.isEmpty()){
                    showStack.push(saveStack.pop());
                    printChar.add('+');
//                    System.out.println("+");
                } else {
                    if(showStack.peek() < x){
                        showStack.push(saveStack.pop());
                        printChar.add('+');
//                        System.out.println("+");
                    } else if (showStack.peek() == x) {
                        showStack.pop();
                        printChar.add('-');
//                        System.out.println("-");
                        break;
                    } else {
                        System.out.println("NO");
                        check = false;
                        flag = false;
                    }
                }
                if(showStack.isEmpty() && saveStack.isEmpty()) flag = false;
            }
            if(!flag) break;
        }
        if(check) while (!printChar.isEmpty()) System.out.println(printChar.poll());
    }
}