import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] temp;
		int[] answer;
		temp = new int[arr.length];
		temp[0] = arr[0];
		int j = 1;
		for(int i = 0; i <arr.length-1; i++ ) {
			if(arr[i] != arr[i+1]) {
				temp[j] = arr[i+1];
				j++;
			}
		}
		answer = new int[j];
		System.out.println(j);
		for(int i = 0; i < j; i++) {
			answer[i] = temp[i];
		}
        return answer;
    }
}