class Solution {
    public int solution(int n, int m, int[] section) {
        System.out.println("helloworld");
        // n만큼의 배열을 만들어 놓는다.
        // 그리고 그 중에서 section 배열만 0으로 놓고 나머지는 1로 놓는다.
        // m길이의 롤러를 칠하면 칠한 곳은 1로 바꿔준다.
        // m길이의 롤러 시작 좌표 끝좌표
        
        int[] wall = new int[n+1];
        // wall 에서 0번은 빼고 1번부터 n번까지 사용한다.
        
        for(int i = 1; i <= n; i++){
            wall[i] = 1;
        }
        for(int i = 0; i < section.length; i++){
            wall[section[i]] = 0;
        }
        for(int i = 1; i <= n; i++){
            System.out.print(wall[i] + " ");
        }
        int cnt = 0;
        // 다 칠해지지 전까지
        boolean flag = true;
        while(flag){
            for(int i = 1; i <= n; i++){
                if(wall[i] == 0){
                    cnt++;
                    // 이 부분에서 범위 초과임
                    if((i + m) <= n){
                       for(int j = i; j < i+m; j++){
                            wall[j] = 1;
                        } 
                    } else if((i + m) > n){
                        for(int j = i; j <= n; j++){
                            wall[j] = 1;
                        }
                    }
                }
            }
            int sum = 0;
            for(int i = 1; i <= n; i++){
                if(wall[i] == 1){
                    sum++;
                }
            }
            if(sum == n){
                flag = false;
            }
        }
        
        
        int answer = cnt;
        return answer;
    }
}