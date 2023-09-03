import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int i = sc.nextInt();
        char letter = word.charAt(i-1);
        System.out.println(letter);
    }
}