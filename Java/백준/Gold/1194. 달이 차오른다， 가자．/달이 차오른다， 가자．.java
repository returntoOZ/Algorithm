import java.io.*;
import java.util.*;

public class Main {
    static class node{
        int x, y, keys;

        node(int x, int y, int keys){
            this.x = x;
            this.y = y;
            this.keys = keys;
        }
    }

    static int N, M;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static char[][] arr;
    static int[][][] dist;
    static Queue<node>q = new ArrayDeque<>();

    static int bfs(){
        while(!q.isEmpty()){
            node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int keys = cur.keys;
            int prev = dist[cx][cy][keys];

            if(arr[cx][cy] == '1') return prev;

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                char ch = arr[nx][ny];
                if(ch == '#') continue;

                if('A' <= ch && ch <= 'F'){ // 문을 만난 상황
                    int shift = 1 << (ch - 'A');
                    if((keys & shift) == 0) continue; // 통과 불가능

                    if(dist[nx][ny][keys] <= prev + 1) continue;
                    dist[nx][ny][keys] = prev + 1;
                    q.offer(new node(nx, ny, keys));
                }else if('a' <= ch && ch <= 'f'){ // 열쇠를 만난 상황
                    int shift = 1 << (ch - 'a');
                    int newkeys = keys | shift;

                    if(dist[nx][ny][newkeys] <= prev + 1) continue;
                    dist[nx][ny][newkeys] = prev + 1;
                    q.offer(new node(nx, ny, newkeys));
                }else{ // 지나갈 수 있는 곳을 만난 상황
                    if(dist[nx][ny][keys] <= prev + 1) continue;
                    dist[nx][ny][keys] = prev + 1;;
                    q.offer(new node(nx, ny, keys));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        dist = new int[N][M][64];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == '0'){
                    q.offer(new node(i,j, 0));
                    dist[i][j][0] = 0;
                }
            }
        }

        System.out.print(bfs());
    }
}
