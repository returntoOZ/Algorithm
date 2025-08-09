import java.io.*;
import java.util.*;

public class Solution {
    static int T, N, L, ans, cur = 1;
    static int[] s, c; // s: 점수, c: 칼로리

    static void powerset(int idx, int sc,int cal){
        if(idx == N){
            if(cal <= L){
                ans = Math.max(ans, sc);
            }
            return;
        }

        if(cal > L) return;

        powerset(idx+1, sc + s[idx], cal + c[idx]);
        powerset(idx+1, sc, cal);
    }

    public static void main(String[] args)throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            s = new int[N];
            c = new int[N];
            ans = -1;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                s[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }

            powerset(0,0,0);
            sb.append("#").append(cur++).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}