import java.util.*;

class Solution {
    // 0~9의 영문을 저장하는 hashMap 준비
    public int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                answer.append(cur);       
                continue;
            }
            
            sb.append(cur);
            if(map.containsKey(sb.toString())){
                int num = map.get(sb.toString());
                answer.append(num);
                sb.setLength(0);
            }
        }
        
        int ans = Integer.parseInt(answer.toString());
        return ans;
    }
}