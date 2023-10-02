import java.util.*;
class Solution {
    static boolean[] visited;
    Stack<Integer> stack = new Stack<>();
   
    public int solution(int n, int[][] computers) {
        
        // computers 배열 출력
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                System.out.print(computers[i][j] + " ");
            }
            System.out.println();
        }
        
        // 방문 노드를 나타내는 배열 초기화
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }
        
        // 영역의 개수를 측정할 변수 cnt
        int cnt = 0;
        
        for(int i = 0; i < n; i++){
            // 미방문 노드라면 네트워크 수를 하나 늘리고 스택에 추가한다. 
            if(visited[i] == false){
                cnt++;
                stack.add(i);
                // 동시에 방문한 노드로 처리한다.
                visited[i] = true;
            }
            // 스택이 비어있지 않는 경우 stack.isEmpty() != true
            while(stack.isEmpty() != true){
                // 스택에서 노드 하나를 뽑는다.
                int current = stack.pop();
                // 뽑은 노드와 인접한 노드가 있는지 확인한다.
                for(int j = 0; j < n; j++){
                    // 뽑은 노드와 인접하고 미방문 노드라면 스택에 추가한다.
                    if(computers[current][j] == 1 && visited[j] == false){
                        // 스택에 넣어준다.
                        stack.add(j);
                        // 방문 처리 해준다.
                        visited[j] = true;
                    }
                }
            }
        }
        
        System.out.println(cnt);
        int answer = cnt;
        return answer;
    }
}