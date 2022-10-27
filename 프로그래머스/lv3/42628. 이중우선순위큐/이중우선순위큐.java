import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String a : operations){
            StringTokenizer st = new StringTokenizer(a);
            
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            System.out.println(command+","+num);
            
            if(command.equals("I")){
                pq.offer(num);
                rpq.offer(num);
            } else{
                if(pq.isEmpty()){
                    continue;
                }
                
                if(num==1){
                    int max = rpq.poll();
                    pq.remove(max);
                } else{
                    int min = pq.poll();
                    rpq.remove(min);
                }
            }
        }
        
        if(pq.size()>0){
            answer[0] = rpq.poll();
            answer[1] = pq.poll();
        } 

        return answer;
    }
}