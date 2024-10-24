import java.util.*;

class Solution {
    int sortNum = 0;
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        System.out.println("helloworld");
        
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[0].length; j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("어떤 정보를 기준으로 데이터를 뽑아낼지: " + ext);
        System.out.println("뽑아낼 정보의 기준값을 나타내는 정수: " + val_ext);
        System.out.println("정보를 저장할 기준이 되는 문자열: " + sort_by);
        
        // 어떤걸 기준으로 오름차순 정렬을 해야할지 정한다 먼저.
        
        if(sort_by.equals("code")) {
            sortNum = 0;
        } else if (sort_by.equals("date")) {
            sortNum = 1;
        } else if(sort_by.equals("maximum")) {
            sortNum = 2;
        } else {
            sortNum = 3;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[sortNum]==o2[sortNum]) return o1[sortNum]-o2[sortNum];
				return o1[sortNum]-o2[sortNum];
            }
        });
        
        for(int i = 0; i < data.length; i++) {
            if(ext.equals("code")) {
                if(data[i][0] < val_ext) pq.add(data[i]);
            } else if(ext.equals("date")) {
                if(data[i][1] < val_ext) pq.add(data[i]);
            } else if(ext.equals("maximum")) {
                if(data[i][2] < val_ext) pq.add(data[i]);
            } else {
                if(data[i][3] < val_ext) pq.add(data[i]);
            }
        }
        
        int num = pq.size();
        int[][] answer = new int[num][3];
        for(int i = 0; i < num; i++){
            answer[i] = pq.poll();
        }
        return answer;
    }
}