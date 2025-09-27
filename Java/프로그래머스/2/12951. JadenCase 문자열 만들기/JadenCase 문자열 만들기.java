import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean start = true; // 단어의 시작인 지
        
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            if(a == ' '){
                sb.append(a);
                start = true;
                continue;
            }
            
            if(start){
                start = false;
                if(Character.isLowerCase(a)) {
                    sb.append(Character.toUpperCase(a));
                    continue;
                }
                sb.append(a);
            }
            else{
                if(Character.isUpperCase(a)) {
                    sb.append(Character.toLowerCase(a));
                    continue;
                }
                sb.append(a);
            }
        }

        return sb.toString();
    }
}