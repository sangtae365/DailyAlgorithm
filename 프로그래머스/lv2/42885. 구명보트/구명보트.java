import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int i = 0;
        Arrays.sort(people);
        
        for(int j=people.length-1;j>=i;j--){
            if(people[i]+people[j]<=limit){
                answer++;
                i++;
            }else{
                answer++;
            }
        }
        
        return answer;
    }
}