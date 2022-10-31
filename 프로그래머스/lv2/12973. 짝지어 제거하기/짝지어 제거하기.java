import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stack = new Stack<>();
        

        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            
            if(stack.size()>0){
                if(cur==stack.peek()){
                    stack.pop();
                } else{
                    stack.add(cur);
                }
            }
            else{
                stack.add(cur);
            }
        }
        
        System.out.println(stack.size());
        
        if(stack.size()==0){
            answer = 1;
        } else{
            answer = 0;
        }
        
        return answer;
    }
}