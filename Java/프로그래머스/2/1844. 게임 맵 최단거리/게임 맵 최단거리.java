import java.util.*;

class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    static class node{
        int x;
        int y;
        
        node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int bfs(int[][] maps){
        int n = maps.length, m = maps[0].length;
        
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dist[i], -1);
        
        Queue<node> q = new ArrayDeque<>();
        q.offer(new node(0,0));
        dist[0][0] = 1;
        
        while(!q.isEmpty()){
            node cur = q.poll();
            int x = cur.x, y = cur.y;
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(maps[nx][ny] == 0) continue;
                if(dist[nx][ny] != -1 && dist[x][y] + 1 >= dist[nx][ny]) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new node(nx, ny));
            }
        }
        
        return dist[n-1][m-1];
    }
}