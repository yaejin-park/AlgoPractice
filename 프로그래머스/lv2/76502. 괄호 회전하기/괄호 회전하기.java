import java.io.*;
import java.util.*;


class Solution {
    public int solution(String s) {
        int answer = 0;
        
        
        for(int j=0; j<s.length(); j++){
            Stack<Character> stack = new Stack<>();
            boolean isAvail = true;
            
            for(int i=0; i<s.length(); i++){
                char cur = s.charAt((i+j)%s.length());
                
                if(cur=='[' || cur =='(' || cur=='{'){
                    stack.push(cur);
                } else{
                    if(!stack.isEmpty()){
                        char before = stack.pop();
                        if(!isCouple(cur, before)){
                            isAvail=false;
                            break;
                        } 
                    } else{
                        isAvail=false;
                        break;
                    }
                }
            }
            if(isAvail && stack.size()==0) answer++;
        }
        
        

        
        return answer;
    }
    static public boolean isCouple(char cur, char before){
        if(before=='[' && cur==']') return true;
        if(before=='(' && cur==')') return true;
        if(before=='{' && cur=='}') return true;
        return false;
    }
}