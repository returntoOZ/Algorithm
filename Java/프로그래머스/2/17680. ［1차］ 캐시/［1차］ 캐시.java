import java.util.*;
// ArrayList 
// 1. list.size() < cacheSize 삽입
// 2. list.size() == cacheSize
//      1) list 내에 있으면, 해당 idx 찾고, remove(idx) & add 
//      2) list 내에 없으면, remove(0) 하고 add


class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0){
            return cities.length * 5;       
        }
        
        int sum = 0;
        ArrayList<String> cache = new ArrayList<>();
        
        for(int i=0; i<cities.length; i++){
            String cur = cities[i].toLowerCase();
            int sz = cache.size();
            
            if(sz < cacheSize){
                boolean flag = true;
                for(int j=0; j<sz; j++){
                    if(cache.get(j).equals(cur)){
                        cache.remove(j);
                        cache.add(cur);
                        sum += 1;
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    cache.add(cur);
                    sum += 5;
                }
            }else{
                boolean flag = true;
                for(int j=0; j<sz; j++){
                    if(cache.get(j).equals(cur)){
                        cache.remove(j);
                        cache.add(cur);
                        sum += 1;
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    cache.remove(0);
                    cache.add(cur);
                    sum += 5;
                }
            }
        }
        
        return sum;
    }
}