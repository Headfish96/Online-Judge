import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] common) {
        /*
        등차수열: n+1 번째 원소 - n번째 원소의 값과
        n번째 원소 - n-1 번째 원소의 값이 같아야하며
        등비수열이면 안되니까 n+1번째 원소와 n번째 원소를 나눈 값이 
        */
        int answer = 0;
        System.out.println(common.length);
        if((common[1] - common[0]) == (common[2] - common[1])){
            System.out.println("등차수열");
            System.out.println("common행렬의 마지막 원소의 값" + common[common.length-1]);
            answer = common[common.length-1] + common[1] - common[0];
        }else if((common[2]%common[1] ==  0) && (common[1]%common[0] == 0)){
            System.out.println("등비수열");
            System.out.println("common행렬의 마지막 원소의 값" + common[common.length-1]);
            answer = common[common.length-1] * (common[1]/common[0]);
        }
        //
        return answer;
    }
}