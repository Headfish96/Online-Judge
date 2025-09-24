import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tSize = new HashMap<>();
        for (int t : tangerine) {
            Integer key = t;
            tSize.put(key, tSize.getOrDefault(key, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int val : tSize.values()) {
            pq.add(val);
        }
        int count = 0;
        while(0 < k){
            k -= pq.poll();
            count++;
        }
        int answer = count;
        return answer;
    }
}