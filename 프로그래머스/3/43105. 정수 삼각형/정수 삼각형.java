class Solution {
    public int solution(int[][] triangle) {
        
        // 삼각형이 몇 행까지 있는지 확인
        int n = triangle.length;
        
        // 행의 갯수만큼 dp 배열 생성
        int[] dp = new int[n];

        // 꼭대기 초기화: 첫 행의 유일한 값
        dp[0] = triangle[0][0];

        // 1행부터 내려가며 dp 덮어쓰기
        for (int i = 1; i < n; i++) {
            // j를 뒤에서 앞으로! (오염 방지)
            for (int j = i; j >= 0; j--) {
                int val = triangle[i][j];
                // i가 1이고 j가 1이면 val은 triangel[i][j] 이건 3아닌가
                if (j == i) {                // 오른쪽 가장자리: 왼쪽 위에서만 옴
                    dp[j] = dp[j - 1] + val;
                    // 15
                } else if (j == 0) {         // 왼쪽 가장자리: 바로 위에서만 옴
                    dp[j] = dp[j] + val;
                    // 
                } else {                     // 내부: 두 경로 중 큰 것 선택
                    dp[j] = Math.max(dp[j - 1], dp[j]) + val;
                }
            }
        }

        // 마지막 행에서 최대값이 정답
        int answer = 0;
        for (int x : dp) answer = Math.max(answer, x);
        return answer;
      
    }
}