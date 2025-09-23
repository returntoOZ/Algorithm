import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder(new_id);
    // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(Character.isUpperCase(c)){
                sb.setCharAt(i, Character.toLowerCase(c));
            }
        }
        
    // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for(int i=sb.length()-1; i>=0; i--){
            char c = sb.charAt(i);
            
            if(c == '-' || c == '_' || c == '.') continue;
            if(Character.isLowerCase(c)) continue;
            if(Character.isDigit(c)) continue;
            
            sb.deleteCharAt(i);
        }
        
    // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for(int i=1; i<sb.length(); i++){
            char cmp1 = sb.charAt(i);
            char cmp2 = sb.charAt(i-1);
            
            if(cmp1 == '.' && cmp1 == cmp2){
                sb.deleteCharAt(i--);
            }
        }
    // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        while(true){
            char first = sb.charAt(0);
            char last = sb.charAt(sb.length()-1);
            
            if(first != '.' && last != '.') break;
            
            if(first == '.') sb.deleteCharAt(0);
            if(sb.toString().isEmpty()) break;
            if(last == '.') sb.deleteCharAt(sb.length()-1);
            if(sb.toString().isEmpty()) break;
        }
        
    // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(sb.toString().isEmpty()) sb.append('a');
        
    // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    //      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(sb.length() > 15){
            while(sb.length() != 15){
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
         if(sb.charAt(sb.length()-1) == '.'){
             sb.deleteCharAt(sb.length() - 1);
         };
  
        
    // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(sb.length() < 3){
            while(sb.length() != 3){
                sb.append(sb.charAt(sb.length()-1));
            }
        }
        
        String ans = sb.toString();
        return ans;
    }
}