import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k) {
        int sale = n/10;
        k = k - sale;
        int sum = k*2000 + n*12000;
        int answer = sum;
        return answer;
    }
}