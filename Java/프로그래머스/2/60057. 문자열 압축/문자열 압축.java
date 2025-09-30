import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        if(n == 1) return 1;
        
        int ans = n;
        
        for(int unit=1; unit<= n/2; unit++){
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, unit);
            int cnt = 1;
            
            for(int i=unit; i + unit <= n; i+= unit){
                String cmp = s.substring(i, i+unit);
                
                if(prev.equals(cmp)){
                    cnt++;
                }else{
                    if(cnt > 1) sb.append(cnt);
                    sb.append(prev);
                    prev = cmp;
                    cnt = 1;
                }
            }
            
            if(cnt > 1) sb.append(cnt);
            sb.append(prev);
            
            int rest = n%unit;
            if(rest > 0){
                sb.append(s.substring(n-rest));
            }
            
            ans = Math.min(ans, sb.length());
        }
        
        return ans;
    }
}