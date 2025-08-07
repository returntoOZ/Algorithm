import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, cnt=1;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr, dist;

    static class node{
        int x;
        int y;

        node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y){
        Queue<node> q = new ArrayDeque<>();
        q.offer(new node(x,y));
        dist[x][y] = arr[x][y];

        while(!q.isEmpty()){
            node cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(dist[nx][ny] <= dist[cur.x][cur.y] + arr[nx][ny]) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + arr[nx][ny];
                q.offer(new node(nx, ny));
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while((N = Integer.parseInt(br.readLine())) != 0){
            arr = new int[N][N];
            dist = new int[N][N];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                Arrays.fill(dist[i], INF);
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(0,0);
            sb.append("Problem ").append(cnt++).append(": ").append(dist[N-1][N-1]).append("\n");
        }
        System.out.print(sb);
    }
}