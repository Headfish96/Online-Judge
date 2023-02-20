

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arrN;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arrN = new int[N];
        for(int i = 0 ; i < arrN.length ; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arrM = new int[M];
        for(int i = 0 ; i < arrM.length ; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < arrM.length; i++) {
        	call3(arrM[i]);
        }

	}
	private static void call3(int find) {
		if(Arrays.binarySearch(arrN, find) >= 0) {
			System.out.println(1);
		}else
			System.out.println(0);
	}
}
