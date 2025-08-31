class Solution {
    public int[] solution(String s) {
        
        int CircleCount = 0; // 이진 변환의 횟수 카운트
        int ZeroCount = 0; // 변환 과정에서 제거된 모든 0의 갯수 누적
        boolean flag = true;
        while(flag) {
            CircleCount += 1;
            // System.out.println(CircleCount + " 회차 시작");
            // System.out.println("변환 전 문자열: " + s);
            int count = 0; // 한 회사에 사용되는 1의 갯수 카운팅
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1'){
                    count += 1;
                } else {
                    ZeroCount += 1;
                }
            }
            s = Integer.toBinaryString(count);
            // System.out.println("변환 후 문자열: " + s);
            if(s.equals("1"))  flag = false;
        }
        int[] answer = {CircleCount, ZeroCount};
        return answer;
    }
}