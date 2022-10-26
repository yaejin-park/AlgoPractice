class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //가로가 더 길다
        
        //1. brown +4 /2 
        int sum = (brown+4)/2-4;
        
        for(int i=1; i<=sum/2; i++){
            if(i*(sum-i)==yellow){
                answer[0] = sum-i+2;
                answer[1] = i+2;
                break;
            }
        }
        
        return answer;
    }
}