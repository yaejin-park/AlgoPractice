import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int from = commands[i][0]-1;
            int to = commands[i][1];
            int k = commands[i][2];
            
            
            int[] arr = new int[to-from];
            int idx = 0;
            for(int j=from; j<to; j++){
                arr[idx++] = array[j];
                System.out.println(array[j]);
            }
            Arrays.sort(arr);
         
            
            answer[i] = arr[k-1];
        }
        
        return answer;
    }
}