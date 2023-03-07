import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 숫자 전부 빼준다고 생각하고
 * 등장하는 숫자를 전부 더한 다음에
 * 첫 숫자부터 - 가 등장하기까지의 숫자들의 합 * 2 - 등장하는 숫자들의 총
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String carculate = br.readLine();
		String[] arr = carculate.split("-");
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			for(String str : arr[i].split("\\+")) {
				sum += Integer.parseInt(str);
			}
		}
		int firstnum = 0;
		for(String str : arr[0].split("\\+")) {
			firstnum += Integer.parseInt(str);
		}
		System.out.println(firstnum*2 - sum);
	}
}

//55-50+40-10+20+30+40-00009-00009