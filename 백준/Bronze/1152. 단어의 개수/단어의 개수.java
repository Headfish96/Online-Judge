import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(txt, " ");
        System.out.println(tokenizer.countTokens());
    }
}