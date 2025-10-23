import java.io.*;

class Solution {
    public int solution(String name) {
        int length = name.length();
        int move = length - 1, cnt = 0;
        
        for(int i=0; i<length; i++){
            int gap1 = Math.abs(name.charAt(i) - 'A');
            gap1 = Math.min(26-gap1, gap1);
            cnt += gap1;
            
            int seq = i+1;
            while(seq < length && name.charAt(seq) == 'A') seq++;
            move = Math.min(move, (length-seq)*2 + i);
            move = Math.min(move, i*2 + (length-seq));
        }
        
        return cnt + move;
    }
}