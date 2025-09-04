import java.io.*;
import java.util.*;

public class Main {
    static class node{
        int x;
        int y;
        int w;

        node(int x, int y, int w){
             this.x = x;
             this.y = y;
             this.w = w;
        };


    }

    static int N, cur=1;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr, dist;

    static int bfs(int x, int y){
        PriorityQueue<node> pq = new PriorityQueue<>(
                (o1, o2) -> o1.w - o2.w
        );
        pq.offer(new node(x,y, arr[x][y]));
        dist[x][y] = arr[x][y];

        while(!pq.isEmpty()){
            node cur = pq.poll();

            if(cur.x == N-1 && cur.y == N-1) break;

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(dist[nx][ny] <= dist[cur.x][cur.y] + arr[nx][ny]) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + arr[nx][ny];
                pq.offer(new node(nx, ny, dist[nx][ny]));
            }
        }

        return dist[N-1][N-1];
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            arr = new int[N][N];
            dist = new int[N][N];


            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(cur++).append(": ").append(bfs(0,0)).append("\n");
        }

        System.out.print(sb);
    }
}
