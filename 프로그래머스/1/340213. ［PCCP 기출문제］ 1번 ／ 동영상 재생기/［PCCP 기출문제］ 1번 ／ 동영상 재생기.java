import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        String[] temp = video_len.split(":");
        int RunningTime = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        temp = pos.split(":");
        int CurrentTime = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        temp = op_start.split(":");
        int opStartTime = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        temp = op_end.split(":");
        int opEndTime = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        
        System.out.println("총 재생 시간: " + RunningTime);
        System.out.println("현재 재생 위치: " + CurrentTime);
        System.out.println("오프닝 시작 위치: " + opStartTime);
        System.out.println("오프닝 종료 위치: " + opEndTime);
        
        int commandCheck = 0;
        while(commandCheck != commands.length){
            if(opStartTime <= CurrentTime && CurrentTime <= opEndTime){
                CurrentTime = opEndTime;
            }
            System.out.println("오프닝 건너뛰기 후 현재 위치: " + CurrentTime);
            
            System.out.println("명령: " + commands[commandCheck]);
            if(commands[commandCheck].equals("next")){
                if(RunningTime - CurrentTime <= 10){
                    CurrentTime = RunningTime;
                } else {
                    CurrentTime += 10;
                }
            } else if(commands[commandCheck].equals("prev")) {
                if(CurrentTime <= 10) {
                    CurrentTime = 0;
                } else {
                    CurrentTime -= 10;
                }
            }
            
            if(opStartTime <= CurrentTime && CurrentTime <= opEndTime){
                CurrentTime = opEndTime;
            }
            
            commandCheck++;
        }

        System.out.println("명령 종료 후 현재 위치: " + CurrentTime);
        System.out.println(CurrentTime/60);
        System.out.println(CurrentTime%60);
        
        String mm;
        if(CurrentTime/60 < 10){
            mm = "0" + Integer.toString(CurrentTime/60);
        } else {
            mm = Integer.toString(CurrentTime/60);
        }
        System.out.println(mm);
        
        String ss;
        if(CurrentTime%60 < 10){
            ss = "0" + Integer.toString(CurrentTime%60);
        } else {
            ss = Integer.toString(CurrentTime%60);
        }
        System.out.println(ss);
        
        String answer = mm + ":" + ss;
        return answer;
    }
}