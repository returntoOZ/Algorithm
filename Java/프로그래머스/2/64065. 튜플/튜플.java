import java.io.*;
import java.util.*;
// 무조건 N개의 집합이 만들어짐

class Solution {
    class node implements Comparable<node>{
        String num;
        int cnt;
        
        node(String num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(node n){
            return n.cnt - this.cnt;
        }
    }
    
    public int[] solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            
            if(Character.isDigit(cur)){
                sb.append(cur);
            }else{
                if(sb.length() == 0) continue;
                String str = sb.toString();
                map.put(str, map.getOrDefault(str, 0) + 1);
                sb.setLength(0);
            }
        }
        
        ArrayList<node> list = new ArrayList<>();
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String n = entry.getKey();
            int c = entry.getValue();
            
            list.add(new node(n,c));
        }
        
        Collections.sort(list);
        
        int idx = 0;
        int[] answer= new int[list.size()];
        for(node n : list){
            answer[idx++] = Integer.parseInt(n.num);
        }
        return answer;
    }
}