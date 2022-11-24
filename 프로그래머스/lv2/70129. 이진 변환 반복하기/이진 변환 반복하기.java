import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        int cnt = 0;
        int zero_cnt = 0;
        while(!s.equals("1")){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '0')zero_cnt++;
            }
            s = s.replace("0", "");
            int length = s.length();
            
            s = Integer.toBinaryString(length);
            cnt++;
        }
        int[] answer = {cnt, zero_cnt};
        
        return answer;
    }
}