import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0){
            return 5 * cities.length;
        }
        
        Queue<String> list = new LinkedList<>();
        
        for(int i=0;i<cities.length;i++){
            String city = cities[i].toLowerCase();
            
            if(!list.contains(city)){
                answer += 5;
                if(list.size() == cacheSize){
                    list.poll();
                }
            }else{
                answer += 1;
                list.remove(city);
            }
            list.add(city);
        }
        
        
        return answer;
    }
}