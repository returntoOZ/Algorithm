import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {0,1,0,-1,1,1,-1,-1};
    static int[] dy = {1,0,-1,0,1,-1,1,-1};

    static class node{
        int x;
        int y;

        node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(node st){
        Queue<node> q = new ArrayDeque<>();
        q.offer(st);
        check[st.x][st.y] = true;

        while(!q.isEmpty()){
            node cur = q.poll();

            for(int i=0; i<8; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if(check[nx][ny] || arr[nx][ny] == 0) continue;
                check[nx][ny] = true;
                q.offer(new node(nx, ny));
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            List<node> vector = new ArrayList<>(); // 모든 섬 위치 삽입
            int cnt=0;
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr = new int[h][w];
            check = new boolean[h][w];
            for(int i=0; i<h; i++) Arrays.fill(check[i], false);

            if(w==0 && h==0) break;

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                    if(num == 1) vector.add(new node(i,j));
                }
            }

            for(node cur : vector){
                if(check[cur.x][cur.y]) continue;
                bfs(cur);
                cnt++;
            }

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
