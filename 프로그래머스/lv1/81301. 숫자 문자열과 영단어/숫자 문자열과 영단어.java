import java.util.*;
import java.lang.*;
class Solution {
    public int solution(String s) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0;i<10;i++){
            s = s.replace(words[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}