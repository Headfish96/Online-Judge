import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String arr[] = s.split(" ");
        int len = arr.length;
        int[] a = new int[len];
        for(int i = 0; i < len; i++){
            a[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(a);
        String answer = a[0] + " " + a[len-1];
        return answer;
    }
}