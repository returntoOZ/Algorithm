import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str1.length(); i++){
            char cur = str1.charAt(i);
            if((cur >= 'a' && cur <= 'z') || (cur >= 'A' && cur <= 'Z')){
                cur = Character.toLowerCase(cur);
                sb.append(cur);
                if(sb.length() == 2){
                    String str = sb.toString();
                    map1.put(str, map1.getOrDefault(str, 0) + 1);
                    set.add(str);
                    sb.deleteCharAt(0);
                }
            }else{
                sb.setLength(0); 
            }
        }
        
        sb.setLength(0);
        
        for(int i=0; i<str2.length(); i++){
            char cur = str2.charAt(i);
            if((cur >= 'a' && cur <= 'z') || (cur >= 'A' && cur <= 'Z')){
                cur = Character.toLowerCase(cur);
                sb.append(cur);
                if(sb.length() == 2){
                    String str = sb.toString();
                    map2.put(str, map2.getOrDefault(str, 0) + 1);
                    set.add(str);
                    sb.deleteCharAt(0);
                }
            }else{
                sb.setLength(0); 
            }
        }
        
        int inter = 0, uni = 0;
        for(String s : set){
            // 둘다 존재 : 교집합에 추가
            // 한쪽에만 존재 : 합집합에만 추가
            boolean flag1 = map1.containsKey(s);
            boolean flag2 = map2.containsKey(s);
            
            if(flag1 && flag2){
                inter += Math.min(map1.get(s), map2.get(s));
                uni += Math.max(map1.get(s), map2.get(s));
            }else if(flag1){
                uni += map1.get(s);
            }else if(flag2){
                uni += map2.get(s);
            }
        }
        
        if(uni == 0) return 65536;
        double jakard = ((double)inter)/((double)uni);
        jakard *= 65536;
        
        return (int)jakard;
    }
}