// import java.util.*;

// class Solution {
//     public String solution(String s) {
//         String words[] = s.split(" ", -1);
//         String answer = "";
        
//         for(int i = 0; i < words.length; i++){
            
//             words[i] = words[i].toLowerCase();
            
//             char first = Character.toUpperCase(words[i].charAt(0));
            
//             words[i] = first + words[i].substring(1);
            
//             answer += words[i];
           
//         }
//         return answer;
//     }
// }

class Solution {
    public String solution(String s) {
        String[] parts = s.split(" ", -1); // 연속/끝 공백 보존
        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < parts.length; i++) {
            String w = parts[i];
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0)));
                for (int j = 1; j < w.length(); j++) {
                    sb.append(Character.toLowerCase(w.charAt(j)));
                }
            }
            if (i + 1 < parts.length) sb.append(' '); // 원래 공백 개수 유지
        }
        return sb.toString();
    }
}
