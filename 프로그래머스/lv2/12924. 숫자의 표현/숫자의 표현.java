class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++){
            int sum = 0;
            int temp = i;
            while(sum<=n){
                if(sum == n)answer++;
                sum+=temp++;
            }
        }
        
        return answer;
    }
}