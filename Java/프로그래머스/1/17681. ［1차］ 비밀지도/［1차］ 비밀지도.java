import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] arr = new int[n];
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            arr[i] = arr1[i] | arr2[i];
            trans(n, arr[i], list);
        }
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    static void trans(int n, int num, ArrayList<String> list){
        StringBuilder sb = new StringBuilder();
        int cur = 1 << (n-1);
        
        for(int i=0; i<n; i++){
            if(num >= cur){
                sb.append('#');
                num -= cur;
                cur /= 2;
            }else{
                sb.append(' ');
                cur /= 2;
            }
        }
        
        list.add(sb.toString());
    }
}