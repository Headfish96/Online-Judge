

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		
		int numSwitch = sc.nextInt(); // 스위치의 개수를 입력받는다.
		int[][] sexNswitch = new int[2][numSwitch];
		int[] switchStatus = new int[numSwitch]; //입력받은 스위치의 개수만큼 스위치의 상태를 저장하는 배열을 선언한다. 켜져있으면 1, 꺼지면 0
		//int[] pstatus = new int[];
		for(int i = 0; i < numSwitch; i++) {
			switchStatus[i] = sc.nextInt();
		} // 사용자로부터 스위치의 상태를 입력받는다.
		
		int numStudent = sc.nextInt();
		for(int i = 0; i < numStudent; i++) {
			int symmetry = 0;
			int sex = sc.nextInt(); // 성
			int Nswitch = sc.nextInt(); // 자기가 받은 수
			if(sex == 1) { //남자인 경우
				for(int j = 0; j < numSwitch; j++) { //스위치번호를 하나씩 돌면서
					if((j+1)%Nswitch == 0) {
						if(switchStatus[j] == 0) {
							switchStatus[j] = 1;
						}else
							switchStatus[j] = 0;
					}
				}
			}
			else if(sex == 2) { //학생 성별이 여자인 경우
				if(Nswitch - 1 > numSwitch - Nswitch) { // 내가 받은 번호가 스위치의 중간 이상인 경
					for(int j = 1; j <= numSwitch - Nswitch; j++) {
						if (switchStatus[Nswitch-1+j] == switchStatus[Nswitch-1-j]) {
							symmetry += 1;
						}else break;
					}
				}else {
					for(int j = 1; j <= Nswitch-1; j++) {
						if (switchStatus[Nswitch-1+j] == switchStatus[Nswitch-1-j]) {
							symmetry += 1;
						}else break;
					}
				}
				for(int k = Nswitch - symmetry -1; k <= Nswitch + symmetry -1; k++) {
					if(switchStatus[k] == 0) {
						switchStatus[k] = 1;
					}else
						switchStatus[k] = 0;
				}
			}
		}
		
		for(int j = 0; j < switchStatus.length; j++) {
			System.out.print(switchStatus[j] + " ");
			if((j+1)%20 == 0) {
				System.out.println();
			}
		}
		
		
	}
}

