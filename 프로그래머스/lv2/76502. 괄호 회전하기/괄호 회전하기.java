import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            int cnt = 0;
            int loc = i;
            boolean flag = true;
            while(cnt<s.length()){
                loc %= s.length();
                char ch = s.charAt(loc);
                if(ch == ')'){
                    if(!st.isEmpty() && st.peek() == '('){
                        st.pop();
                    }else{
                        flag = false;
                        break;
                    } 
                }else if(ch == '}'){
                    if(!st.isEmpty() && st.peek() == '{'){
                        st.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }else if(ch == ']'){
                    if(!st.isEmpty() && st.peek() == '[')st.pop();
                    else {
                        flag = false;
                        break;
                    }
                }else{
                    st.add(ch);
                }
                loc++;
                cnt++;
            }
            if(st.isEmpty() && flag)answer++;
        }
        
        return answer;
    }
}