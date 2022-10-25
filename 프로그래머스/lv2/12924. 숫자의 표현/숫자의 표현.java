class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int l = 0;
        int r = 0;
        int sum = 0;
        
        //슬라이딩 윈도우
        while(true){
            // System.out.println(sum);
            if(sum == n){
                answer++;
                sum -=l;
                l++;
                r++;
                sum += r;
            } else if(sum < n){
                r++;
                sum += r;
            } else if(sum > n){
                sum -= l;
                l++;
            }
            if((r==n && sum < n) || l > n){
                break;
            }
        }   
        
        
        return answer;
    }
}