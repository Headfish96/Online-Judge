import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(true){
            int[] tri = new int[3];
            for(int i = 0; i < 3; i++){
                tri[i] = sc.nextInt();
            }
            Arrays.sort(tri);
//            for(int i = 0; i < tri.length; i++){
//                System.out.println(tri[i]);
//            }
            if( tri[0] == 0 && tri[1] == 0 && tri[2] == 0){
//                System.out.println("종료");
                break;
            }
            if(Math.pow((double)tri[2], 2) == (Math.pow((double)tri[0], 2) + Math.pow((double)tri[1], 2)) ){
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }
    }
}