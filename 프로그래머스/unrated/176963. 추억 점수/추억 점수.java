import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // System.out.println("photo에 있는 사진의 수: " + photo.length);
        // for(int i = 0; i < photo.length; i++){
        //     System.out.println(i + "번째 사진에 있는 사람 수: " + photo[i].length);
        //     for(int j = 0; j < photo[i].length; j++){
        //         System.out.println(i + "번째 사진에 있는 " + j + "번째 사람: " + photo[i][j]);
        //     }
        // }
        
        // int[][] nameScore = new int[name.length][name.length];
        // for(int i = 0; i < name.length; i++){
        //     nameScore[i][0] = name[i];
        //     nameScore[i][1] = yearning[i];
        // }
        int[] total = new int[photo.length];
        for(int i = 0; i < photo.length; i++){ // 사진의 수만큼 반복
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++){ 
                for(int k = 0; k < name.length; k++){
                    if(photo[i][j].equals(name[k])){
                      sum += yearning[k];  
                    } 
                }
            }
            System.out.println(sum);
            total[i] = sum;
        }
        
        int[] answer = new int[total.length];
        for(int i = 0; i < total.length; i++) answer[i] = total[i];
        return answer;
    }
}