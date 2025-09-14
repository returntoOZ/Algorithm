import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hash = new HashMap<>();
        
        for(String[] cloth : clothes){
            String type = cloth[1];
            
            hash.put(type, hash.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        
        for(int v : hash.values()){
            answer *= (v+1);
        }
        return answer-1;
    }
}