class Solution {
    public int solution(int[][] sizes) {
        for(int i = 0; i < sizes.length; i++){
            //System.out.println(sizes[i][0]);
            int temp = 0;
            if(sizes[i][0] < sizes[i][1]){
                temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
        }
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i < sizes.length; i++){
            if(maxX < sizes[i][0]) maxX = sizes[i][0];
            if(maxY < sizes[i][1]) maxY = sizes[i][1];
            
        }
        System.out.println("maxX: " + maxX + " maxY: " + maxY);
        
        
        int answer = maxX * maxY;
        return answer;
    }
}