import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] v, w;
    static int[][] dp;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        v = new int[N+1];
        w = new int[N+1];
        dp = new int [N+1][K+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                dp[i][j] = dp[i-1][j];
                if(j-w[i] >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]] + v[i]);
                }
            }
        }

        System.out.print(dp[N][K]);
    }
}
