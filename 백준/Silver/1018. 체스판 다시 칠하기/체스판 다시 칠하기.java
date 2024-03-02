import java.util.Scanner;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // 개행 문자 소비

        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = sc.nextLine();
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= N-8; i++){
            for(int j = 0; j <= M-8; j++) {
                int Acnt = 0;
                int Bcnt = 0;
                int cnt = 0;
                for(int a = i; a < i + 8; a++){
                    for(int b = j; b < j + 8; b++) {
                        if ((a + b) % 2 == 0) {
                            char Astandard = 'W';
                            if (str[a].charAt(b) != Astandard) {
                                Acnt++;
                            }
                            char Bstandard = 'B';
                            if (str[a].charAt(b) != Bstandard) {
                                Bcnt++;
                            }
                        } else if ((a + b) % 2 == 1) {
                            char Astandard = 'B';
                            if (str[a].charAt(b) != Astandard) {
                                Acnt++;
                            }
                            char Bstandard = 'W';
                            if (str[a].charAt(b) != Bstandard) {
                                Bcnt++;
                            }
                        }
                        cnt = min(Acnt, Bcnt);
                    }
                }


                if(cnt <= min) min = cnt;
            }
        }

        System.out.println(min);
    }
}