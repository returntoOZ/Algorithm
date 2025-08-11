import java.io.*;
import java.util.*;

public class Solution{
    static int T, N, M, ans, cur=1;
    static boolean[][] impossible;
    
    static void dfs(int idx, boolean[] pick){
        if (idx > N){
            ans ++;
            return;
        }
        
        dfs(idx + 1, pick);
        
        if (select(idx, pick)){
            pick[idx] = true;
            dfs(idx + 1, pick);
            pick[idx] = false;
        }
    }
    
    static boolean select(int x, boolean[] pick) {
        for (int i = 1; i <= N; i++) {
            if (pick[i] && impossible[x][i]) return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            ans = 0;
            boolean[] pick = new boolean[N + 1];
            impossible = new boolean[N + 1][N + 1];

            for (int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                impossible[a][b] = true;
                impossible[b][a] = true;
            }

            dfs(1, pick);
            sb.append("#").append(cur++).append(' ').append(ans).append("\n");
        }
        System.out.print(sb);
    }
}