import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr, dist;

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void Dijkstra(){
        Node st = new Node(1,1);
        dist[1][1] = 0;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(st);

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;

                if(arr[nx][ny] == 1){ // 이동하려는 곳이 벽!
                    if(dist[nx][ny] <= dist[cur.x][cur.y] + 1) continue; // 최소 개수가 아닌 경우
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    q.offer(new Node(nx, ny));
                }else{ // 이동하려는 곳이 벽이 아님
                    if(dist[nx][ny] <= dist[cur.x][cur.y]) continue; // 최소 개수가 아닌 경우
                    dist[nx][ny] = dist[cur.x][cur.y];
                    q.offer(new Node(nx, ny));
                }
            }
        }

        System.out.print(dist[N][M]);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        dist = new int[N+1][M+1];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            Arrays.fill(dist[i+1], INF);
            for(int j=0; j<M; j++){
                arr[i+1][j+1] = line.charAt(j) - '0';
            }
        }

        Dijkstra();
    }
}