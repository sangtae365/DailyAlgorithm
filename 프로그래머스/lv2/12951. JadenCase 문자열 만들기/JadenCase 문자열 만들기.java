import java.util.*;
import java.lang.*;
import java.io.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                flag = true;
                sb.append(" ");
                continue;
            }
            if(flag){
                sb.append(Character.toUpperCase(ch));
                flag = false;
            }else{
                sb.append(Character.toLowerCase(ch));
            }
        }
        
        return sb.toString();
    }
}