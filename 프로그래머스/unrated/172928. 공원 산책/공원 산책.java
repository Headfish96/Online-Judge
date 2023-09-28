class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 좌표값을 저장하는 클래스 point 초기화
        point current = new point(0,0);
        
        // 시작점을 찾는다.
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    current.r = i;
                    current.c = j;
                }
            }
        }
        
        int Width = park[0].length(); // 공원의 가로길이
        int Hight = park.length; // 공원의 세로길이
        
        for(int i = 0; i < routes.length; i++){
            char deraction = routes[i].charAt(0); // 방향
            int n = Character.getNumericValue(routes[i].charAt(2)); // 거리
            
            // 동쪽으로 n칸 이동하는 경우
            // 범위안에 있는지 확인
            if(deraction == 'E' && (current.c + n) < Width){
                System.out.println("동쪽으로");
                // 경로상에 장애물 유무 확인
                boolean flag = true;
                for(int j = 1; j <= n; j++){
                    if(park[current.r].charAt(current.c + j) == 'X'){
                        flag = false;
                    }
                }
                if(flag == true){
                    current.c += n;
                }
                System.out.println(current.r + " " + current.c);
            }
            // 서쪽으로 n칸 이동하는 경우
            // 범위안에 있는지 확인
            else if(deraction == 'W' && 0 <= (current.c - n)){
                System.out.println("서쪽으로");
                // 경로상에 장애물 유무 확인
                boolean flag = true;
                for(int j = 1; j <= n; j++){
                    if(park[current.r].charAt(current.c - j) == 'X'){
                        flag = false;
                    }
                }
                if(flag == true){
                    current.c -= n;
                }
                System.out.println(current.r + " " + current.c);
            }
            // 북쪽으로 n칸 이동하는 경우
            else if(deraction == 'N' && (0 <=  (current.r - n))){
                System.out.println("북쪽으로");
                boolean flag = true;
                for(int j = 1; j <= n; j++){
                    if(park[current.r - j].charAt(current.c) == 'X'){
                        flag = false;
                    }
                }
                if(flag == true){
                    current.r -= n;
                }
                System.out.println(current.r + " " + current.c);
            }
            // 남쪽으로 n칸 이동하는 경우
            else if(deraction == 'S' && ((current.r + n) <  Hight)){
                System.out.println("남쪽으로");
                boolean flag = true;
                for(int j = 1; j <= n; j++){
                    if(park[current.r + j].charAt(current.c) == 'X'){
                        flag = false;
                    }
                }
                if(flag == true){
                    current.r += n;
                }
                System.out.println(current.r + " " + current.c);
            }
        }
        
        System.out.println(current.r + " " + current.c);
        
        int[] answer = {current.r, current.c};
        return answer;
    }
    
    static class point{
        public int r,c;
        public point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}