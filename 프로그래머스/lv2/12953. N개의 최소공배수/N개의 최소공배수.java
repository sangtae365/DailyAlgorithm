import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int big = arr[arr.length-1];
        while(true){
            boolean flag = true;
            for(int i=0;i<arr.length;i++){
                if(big % arr[i] != 0)flag = false;
            }
            if(flag){
                answer = big;
                break;
            }
            big++;
        }
        
        return answer;
    }
}