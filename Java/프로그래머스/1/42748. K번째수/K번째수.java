import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; 
        
        for(int i=0; i<commands.length; i++){
            int st = commands[i][0], ed = commands[i][1], idx = commands[i][2];
            
            if(st == ed){
                answer[i] = array[st-1];
            }else{   
                int[] tmp = Arrays.copyOfRange(array, st-1, ed);
                Arrays.sort(tmp);
                answer[i] = tmp[idx-1];
            }
        }
        return answer;
    }
}