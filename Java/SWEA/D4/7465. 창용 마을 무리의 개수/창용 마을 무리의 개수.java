import java.io.*;
import java.util.*;

public class Solution {
    static int T, N, M, cur=1;
    static int[] parents;
    static boolean[] chk;

    static void make(){
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }
    }

    static int find(int n){
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }

    static void union(int a, int b){
        int aR = find(a);
        int bR = find(b);

        if(aR == bR) return;
        parents[bR] = aR;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while(T-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parents = new int[N+1];
            chk = new boolean[N+1];
            Arrays.fill(chk, false);
            make();

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a,b);
            }

            int ans = 0;
            for(int i=1; i<=N; i++){
                int R = find(i);
                if(chk[R]) continue;
                chk[R] = true;
                ans++;
            }

            sb.append("#").append(cur++).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
