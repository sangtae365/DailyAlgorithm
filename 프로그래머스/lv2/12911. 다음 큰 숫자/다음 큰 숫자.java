class Solution {
    public int solution(int n) {
        String s = Integer.toBinaryString(n);
        int o_cnt = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1')o_cnt++;
        }
        int temp = n;
        
        while(true){
            temp++;
            int cnt = 0;
            String ss = Integer.toBinaryString(temp);
            for(int i=0;i<ss.length();i++){
                if(ss.charAt(i) == '1')cnt++;
            }
            if(o_cnt == cnt)break;
        }
        
        return temp;
    }
}