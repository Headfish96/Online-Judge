import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int count;
	static int N;
	//2의 n승을 구하는 재귀문
	//n이 주어졌을때 2의 n승이 2차원 배열의 한 변의 길이.
	private static int pow(int n) {
		if(n==1) return 2;
		int y = pow(n/2);
		return n%2 == 0? y*y : y*y*2;
	}
	static void find(int r, int c, int size) {
		if(size == 1)
			return;
		size = size / 2;
		//1사분면에 있는 경우
		if((r < size) && (c < size)) {
			find(r, c, size);
		}else if((r < size) && (c >= size)) {
			c = c - size;
			count = count + size*size;
			find(r, c, size);
		}else if((r >= size) && (c < size)) {
			r = r - size;
			count = count + size*size*2;
			find(r, c, size);
		}else if((r >= size) && (c >= size)) {
			r = r - size;
			c = c - size;
			count = count + size*size*3;
			find(r, c, size);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		count = 0;
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int size = pow(N);
		find(r, c, size);
        System.out.println(count);
		
	}
}