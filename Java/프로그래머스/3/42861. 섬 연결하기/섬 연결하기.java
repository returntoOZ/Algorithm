import java.util.*;

class Solution {
    static class edge{
        int a;
        int b;
        int w;
        
        edge(int a, int b, int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    
    static int[] parent;
    
    static void init(int n){
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }
    
    static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    
    static boolean union(int a, int b){
        int Ra = find(a);
        int Rb = find(b);
        
        if(Ra == Rb) return false;
        parent[Rb] = Ra;
        return true;
    }
    
    static int kruskal(int n, int[][] costs){
        PriorityQueue<edge> pq = new PriorityQueue<>(
          (o1, o2) -> o1.w - o2.w  
        );
        
        for(int[] c : costs){
            pq.offer(new edge(c[0], c[1], c[2]));
        }
        
        int cnt = 0, cost = 0;
        
        while(!pq.isEmpty()){
            if(cnt == n-1) return cost;
            
            edge cur = pq.poll();
            
            int a = cur.a, b = cur.b, w = cur.w;
            
            if(a < 0 || a >= n || b < 0 || b >= n) continue;
            if(!union(a,b)) continue;
            
            cost += w;
            cnt++;
        }
        
        return cost;
    }
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        init(n);
        
        int answer = kruskal(n, costs);
        return answer;
    }
}