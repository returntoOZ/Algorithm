import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int len = p.length(), cnt = 0;
        
        long cmp = Long.parseLong(p);
        
        for(int i=0; i<= t.length()-len; i++){
            Long cmp1 = Long.parseLong(t.substring(i,i+len));
            
            if(cmp1 <= cmp) cnt++;
        }
        
        return cnt;
    }
}