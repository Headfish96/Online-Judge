import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        if(n == 0){
            System.out.println(0);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                list.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(list);
            int a = (int)Math.round(n*0.15);
            double sum = 0;
            for(int i = a; i < n - a; i++){
                sum += list.get(i);
            }
            System.out.println(Math.round(sum/(n-a*2)));
            br.close();
        }
    }
}