import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        boolean ans = true;
        for(int i=0; i<phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                ans = false;
            }
        }
    
        return ans;
    }
}