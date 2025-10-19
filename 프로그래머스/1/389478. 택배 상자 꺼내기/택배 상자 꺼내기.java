class Solution {
    static int[][] board;
    public int solution(int n, int w, int num) {
        int answer = 0;
        int row = 0;  // 행
        int col = w;  // 열
        
        // 택배상자가 가로로 놓는 갯수만큼 딱 맞아 떨어진다면
        if(n%w == 0){
            row = n/w;
        }
        // 택배상자가의 수가 가로로 놓는 갯수로 맞아 떨어지지 않는다면
        else{
            row = n/w+1;
        }
        
        // 택배상자를 놓는 보드 선언
        board = new int[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                //  짝수행
                if(i%2 == 0){
                    int value = w*i+j; // 0부터 설정
                    if(value < n) board[i][j] = value;
                    else board[i][j] = -1;
                }
                // 홀수행
                else {
                    int value = w*(i+1) - j-1; // 0부터 설정
                    if(value < n) board[i][j] = value;
                    else board[i][j] = -1;
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("구하려는 수: " + (num-1));
        System.out.println((num-1)/w);
        if(((num-1)/w)%2 == 0){ // 구하려는 수가 짝수행인지 확인. 구하려는 수를 w로 나눈 몫이 짝수이면 짝수행
            // num이 12라서 
            // 몇번째 행에 원하는 수가 있는지 확인하기 위해서 
            // 구하려는 수가 위치한 행은 (num-1)/w
            // 구하려는 수가 위치한 열에서 시작하는 수는 (num-1)/w * w
            // 구하려는 수가 위치한 열은 num -1 - ((num-1)/w * w)
            if(board[row-1][num -1 - w*((num-1)/w)] != -1){
                answer = (row-1) - (num-1)/w + 1;
            } else {
                answer = (row-1) - (num-1)/w;
            }
        }
        // 구하려는 수가 홀수 행에 있는 경우(1,3,5,...)
        else {
            // 구하려는 수가 위치한 행은 (num-1)w
            // 구하려는 수가 위치한 열에서 오른쪽 끝에 있는 수는 (num-1)/w * w
            // 구하려는 수가 위치한 열에서 왼쪽 끝에 있는 수는 (num-1)/w * w + w - 1
            // 구하려는 수가 위치한 열은 ((num-1)/w * w + w - 1) - (num-1)
            if(board[row-1][((num-1)/w * w + w - 1) - (num-1)] != -1){
                answer = (row-1) - (num-1)/w + 1;
            } else {
                answer = (row-1) - (num-1)/w;
            }
        }
        return answer;
    }
}