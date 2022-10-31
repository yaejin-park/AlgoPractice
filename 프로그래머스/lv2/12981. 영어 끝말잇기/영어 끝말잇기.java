import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);

        char link = words[0].charAt(words[0].length()-1);
        
        for(int i=1; i<words.length; i++){
            if(words[i].charAt(0) != link){ //끝말잇기 실패
                answer[0] = (i+1)%n ==0 ?n : (i+1)%n ;
                answer[1] = (i+1)/n + ((i+1)%n>0? 1 : 0);
                break;
            }
            
            int before = set.size();
            set.add(words[i]);
            int after = set.size();
            
            if(before==after){  //중복 단어
                answer[0] = (i+1)%n ==0 ?n : (i+1)%n ;
                answer[1] = (i+1)/n + ((i+1)%n>0? 1 : 0);
                break;
            }
            link = words[i].charAt(words[i].length()-1);
        }
        

        
        return answer;
    }
}