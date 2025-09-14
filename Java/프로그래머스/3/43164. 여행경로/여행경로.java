import java.util.*;

class Solution {
    List<String> route;
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        route = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        
        dfs("ICN", tickets, 0);
        
        return route.toArray(new String[0]);
    }
    
    boolean dfs(String cur, String[][] tickets, int cnt){
        route.add(cur);
        
        if(cnt == tickets.length){
            return true;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(cur)){
                visited[i] = true;
                
                if(dfs(tickets[i][1], tickets, cnt + 1)){
                    return true;
                }
                
                visited[i] = false;
            }
        }
        
        route.remove(route.size() - 1);
        return false;
    } 
}