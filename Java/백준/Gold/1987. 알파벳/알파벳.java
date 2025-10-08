import java.util.*;
import java.io.*;

public class Main {
    static int R, C, ans = 0;
    static char[][] arr;
    static boolean[] check;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        check = new boolean[26];

        for(int i=0; i<R; i++){
            arr[i] = br.readLine().toCharArray();
        }

        check[arr[0][0] - 'A'] = true;
        dfs(0,0,1);
        System.out.print(ans);
    }

    static void dfs(int x, int y, int cnt){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if(check[arr[nx][ny] - 'A']) continue;

            check[arr[nx][ny] - 'A'] = true;
            dfs(nx, ny, cnt+1);
            check[arr[nx][ny] - 'A'] = false;
        }

        ans = Math.max(ans, cnt);
    }
}
