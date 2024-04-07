import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> array = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int[] temp = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            temp[0] = Integer.parseInt(st.nextToken());
            temp[1] = Integer.parseInt(st.nextToken());
            array.add(temp);
        }

        array.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });

        for(int i = 0; i < array.size(); i++) System.out.println(array.get(i)[0] + " " + array.get(i)[1]);
    }
}