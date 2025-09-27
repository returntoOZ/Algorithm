import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        
        for(String s : completion){
            hash.put(s, hash.getOrDefault(s, 0) + 1);
        }
        
        for(String s : participant){
            int cnt = hash.getOrDefault(s, 0);
            if(cnt == 0) return s;
            hash.put(s, cnt-1);
        }
        
        return "";
    }
}