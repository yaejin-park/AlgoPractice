import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            
            if(a ==')'){
                if(st.size()>0){
                    if(st.pop()!='('){
                        answer = false;
                        break;
                    }
                } else{
                    answer = false;
                    break;
                }
            } else{
                st.push(a);
            }
        }
        
        if(!(answer && st.size()==0)){
            answer = false;
        } 
        

        return answer;
    }
}