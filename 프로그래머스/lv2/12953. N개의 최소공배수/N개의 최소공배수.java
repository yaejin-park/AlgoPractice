import java.io.*;
import java.util.*;


class Solution {
    //유클리드 호제
    static int gcd(int a, int b){
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[0];
        
        for(int i=1; i<arr.length; i++){
            //최대 공약수
            int gcd = gcd(answer,arr[i]);
            
            //최소 공배수
            answer = answer * arr[i]/gcd;
        }
        
        return answer;
    }
}