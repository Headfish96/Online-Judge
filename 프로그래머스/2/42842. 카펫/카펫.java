import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int r = 0;
        int c = 0;
        int x = 1;
        while(true){
            if( x*((brown - 4)/2 - x) == yellow){
                c = x+2;
                r = (brown - 4)/2 - x + 2;
                break;
            }
            x++;
        }
        
        int[] answer = {r,c};
        return answer;
    }
}