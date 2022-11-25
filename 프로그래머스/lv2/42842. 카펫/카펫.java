import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int space = brown + yellow;
        
        for(int i=1;i<space/2;i++){
            if(space%i == 0){
                if((space/i + i)*2 - 4 == brown){
                    answer[0] = Math.max(space/i, i);
                    answer[1] = Math.min(space/i, i);
                }
            }
        }
        return answer;
    }
}