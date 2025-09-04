import java.io.*;
import java.util.*;

public class Main {
    static class node{
        int x;
        int y;
        int cnt;

        node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static char[][] arr;
    static int[][][] dist;

    static void bfs(){
        Queue<node> q = new ArrayDeque<>();
        q.offer(new node(0,0, 0));
        dist[0][0][0] = 1;

        while(!q.isEmpty()){
            node cur = q.poll();
            int cx = cur.x, cy = cur.y, ccnt = cur.cnt;

            if(cx == N-1 && cy == M-1){
                System.out.print(Math.min(dist[cx][cy][0], dist[cx][cy][1]));
                return;
            }

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(arr[nx][ny] == '1') {
                    if(ccnt == 1) continue; // 이미 벽을 뚫은 경우
                    if(dist[nx][ny][ccnt + 1] <= dist[cx][cy][ccnt] + 1) continue;

                    dist[nx][ny][ccnt + 1] = dist[cx][cy][ccnt] + 1;
                    q.offer(new node(nx,ny,ccnt+1));
                }else{
                    if(dist[nx][ny][ccnt] <= dist[cx][cy][ccnt] + 1) continue;

                    dist[nx][ny][ccnt] = dist[cx][cy][ccnt] + 1;
                    q.offer(new node(nx,ny,ccnt));
                }
            }
        }

        System.out.print(-1);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        dist = new int[N][M][2];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
                arr[i][j] = str.charAt(j);
            }
        }

        bfs();
    }
}
