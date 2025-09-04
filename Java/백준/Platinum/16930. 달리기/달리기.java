import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, x1, x2, y1, y2;
    static int[][] dp;
    static char[][] arr;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y){
        dp[x][y] = 0;
        Queue<Node> q = new ArrayDeque<>(

        );
        q.offer(new Node(x,y));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x == x2 && cur.y == y2){
                System.out.println(dp[x2][y2]);
                return;
            }
            for(int i = 0; i < 4; i++){
                for(int j = 1; j <= K; j++){
                    int nx = cur.x + j*dx[i];
                    int ny = cur.y + j*dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) break; // 이 방향으로는 더 이상 갈 수 없음
                    if(arr[nx][ny] == '#') break; // 이 방향으로는 더 이상 갈 수 없음

                    if(dp[nx][ny] < dp[cur.x][cur.y] + 1) break;
                    if(dp[nx][ny] == dp[cur.x][cur.y] + 1) continue;

                    dp[nx][ny] = dp[cur.x][cur.y] + 1;
                    q.add(new Node(nx,ny));
                }
            }
        }

        if(dp[x2][y2] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(dp[x2][y2]);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N][M];
        for(int i=0; i<N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        arr = new char[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        x1--; y1--; x2--; y2--;
        bfs(x1,y1);
    }
}
