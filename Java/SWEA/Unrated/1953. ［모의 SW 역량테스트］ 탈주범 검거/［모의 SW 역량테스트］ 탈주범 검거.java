import java.io.*;
import java.util.*;

public class Solution {
    static class node{
        int x;
        int y;

        node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] arr;
    static int[][] dist;
    static int T, N, M, R, C, L, order=1;

    static int bfs(int x, int y){
        int cnt = 0;
        Queue<node> q = new ArrayDeque<>();
        q.offer(new node(x,y));
        dist[x][y] = 1;
        cnt++;

        while(!q.isEmpty()){
            node cur = q.poll();
            int cx = cur.x, cy = cur.y;
            int ca = arr[cx][cy];

            if(dist[cx][cy] == L) return cnt;

            if(ca == 1){ // 1 : 0,1,2,3 우하좌상
                for(int i=0; i<4; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(dist[nx][ny] > 0 || arr[nx][ny] == 0) continue;
                    int cmp = arr[nx][ny];

                    if(i==0){ // 우
                        if(cmp == 2 || cmp == 4 || cmp == 5) continue;
                    }else if(i==1){ // 하
                        if(cmp == 3 || cmp == 5 || cmp == 6) continue;
                    }else if(i==2){ // 좌
                        if(cmp == 2 || cmp == 6 || cmp == 7) continue;
                    }else { // 상
                        if(cmp == 3 || cmp == 4 || cmp == 7) continue;
                    }

                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.offer(new node(nx, ny));
                    cnt++;
                }
            }else if(ca == 2){ // 2: 1,3
                for(int i=1; i<4; i+=2){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(dist[nx][ny] > 0 || arr[nx][ny] == 0) continue;
                    int cmp = arr[nx][ny];

                    if(i==1){ // 하
                        if(cmp == 3 || cmp == 5 || cmp == 6) continue;
                    }else { // 상
                        if(cmp == 3 || cmp == 4 || cmp == 7) continue;
                    }

                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.offer(new node(nx, ny));
                    cnt++;
                }
            }else if(ca == 3){ // 3 : 0,2
                for(int i=0; i<3; i+=2){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(dist[nx][ny] > 0 || arr[nx][ny] == 0) continue;

                    int cmp = arr[nx][ny];
                    if(i==0){ // 우
                        if(cmp == 2 || cmp == 4 || cmp == 5) continue;
                    }else { // 좌
                        if(cmp == 2 || cmp == 6 || cmp == 7) continue;
                    }

                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.offer(new node(nx, ny));
                    cnt++;
                }
            }else if(ca == 4){ // 4 : 0,3
                for(int i=0; i<4; i+=3){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(dist[nx][ny] > 0 || arr[nx][ny] == 0) continue;
                    int cmp = arr[nx][ny];

                    if(i==0){ // 우
                        if(cmp == 2 || cmp == 4 || cmp == 5) continue;
                    }else { // 상
                        if(cmp == 3 || cmp == 4 || cmp == 7) continue;
                    }

                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.offer(new node(nx, ny));
                    cnt++;
                }
            }else if(ca == 5){ // 5 : 0,1
                for(int i=0; i<2; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(dist[nx][ny] > 0 || arr[nx][ny] == 0) continue;
                    int cmp = arr[nx][ny];

                    if(i==0){ // 우
                        if(cmp == 2 || cmp == 4 || cmp == 5) continue;
                    }else { // 하
                        if(cmp == 3 || cmp == 5 || cmp == 6) continue;
                    }
                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.offer(new node(nx, ny));
                    cnt++;
                }
            }
            else if(ca == 6){ // 6 : 1,2
                for(int i=1; i<3; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(dist[nx][ny] > 0 || arr[nx][ny] == 0) continue;
                    int cmp = arr[nx][ny];

                    if(i==2){ // 좌
                        if(cmp == 2 || cmp == 6 || cmp == 7) continue;
                    }else { // 하
                        if(cmp == 3 || cmp == 5 || cmp == 6) continue;
                    }
                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.offer(new node(nx, ny));
                    cnt++;
                }
            }
            else{ // 7 : 2,3
                for(int i=2; i<4; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(dist[nx][ny] > 0 || arr[nx][ny] == 0) continue;
                    int cmp = arr[nx][ny];

                    if(i==2){ // 좌
                        if(cmp == 2 || cmp == 6 || cmp == 7) continue;
                    }else { // 상
                        if(cmp == 3 || cmp == 4 || cmp == 7) continue;
                    }
                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.offer(new node(nx, ny));
                    cnt++;
                }
            }
        }

        return cnt;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            dist = new int[N][M];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(order++).append(" ").append(bfs(R,C)).append("\n");
        }
        System.out.print(sb);
    }
}