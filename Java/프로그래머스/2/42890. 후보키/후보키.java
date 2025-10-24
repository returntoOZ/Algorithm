import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int col = relation[0].length;
        
        for(int i=1; i<(1 << col); i++){
            // 1부터 2^col-1까지 탐색
            if(!unique(i, relation)) continue;
            
            boolean flag = true;
            for(int a : list){
                if((a & i) == a){
                    flag = false;
                    break;
                }
            }
            if(flag) list.add(i);
        }
        
        return list.size();
    }
    
    static boolean unique(int bitmask, String[][] relation){
        int row = relation.length;
        int col = relation[0].length;
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<row; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<col; j++){
                if((bitmask & (1 << j)) == 0) continue;
                sb.append(relation[i][j]).append("#");
            }
            if(!set.add(sb.toString())) return false; // add가 false 반환(중복 존재한다는 뜻!)
        }
        
        return true;
    }
}