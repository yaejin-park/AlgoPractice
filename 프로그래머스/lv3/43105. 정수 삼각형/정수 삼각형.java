import java.io.*;
import java.util.*;

class Solution {
    static int[] dr = {1,1};
    static int[] dc = {0,1};
    
    static int n;
    static int dp[][];

    static int answer = 0;
    
    public int solution(int[][] triangle) {
        n = triangle.length;
        dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            for(int j=1; j<i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            
            dp[i][i] = dp[i-1][i-1] + triangle[i][i]; 
        }
        
        for(int i=0; i<n; i++){
            answer = Math.max(dp[n-1][i], answer);
        }
        
        return answer;
    }
}