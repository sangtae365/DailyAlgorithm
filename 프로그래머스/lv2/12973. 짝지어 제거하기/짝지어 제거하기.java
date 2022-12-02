import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        Stack<Character> st = new Stack<Character>();
                
        char ch[] = s.toCharArray();
        st.add(ch[0]);
        
        for(int i=1;i<ch.length;i++){
            if(!st.isEmpty() && st.peek() == ch[i])st.pop();
            else st.add(ch[i]);
        }
        if(st.isEmpty())answer = 1;
        
        return answer;
    }
}