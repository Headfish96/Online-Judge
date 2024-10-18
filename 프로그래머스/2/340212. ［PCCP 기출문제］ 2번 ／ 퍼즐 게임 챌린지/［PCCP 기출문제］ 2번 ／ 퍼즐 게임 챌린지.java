import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        while(left < right){
            int mid = (left + right) / 2;
            if(canSolve(mid, diffs, times, limit)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public boolean canSolve(int level, int[] diffs, int[] times, long limit){
        long resolveTime = 0;
        int n = diffs.length;
        for(int cnt = 0; cnt < n; cnt++){
            int diff = diffs[cnt];
            int time_cur = times[cnt];
            if(cnt == 0){
                if(diff > level) {
                    resolveTime += (long)(time_cur) * (diff - level) + time_cur;;
                } else {
                    resolveTime += time_cur;
                }
            } else {
                int time_prev = times[cnt-1];
                if(diff > level) {
                    resolveTime += (long) (time_cur + time_prev) * (diff - level) + time_cur;
                } else {
                    resolveTime += time_cur;
                }
            }
            if(resolveTime > limit){
                return false;
            }
        }
        return true;
    }
}