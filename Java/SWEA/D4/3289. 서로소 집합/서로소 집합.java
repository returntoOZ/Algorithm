import java.io.*;
import java.util.*;

public class Solution {
    static int T, n, m, cur=1;
    static int[] parents;

    static void make(){
        for(int i=1; i<=n; i++){
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
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            parents = new int[n+1];
            make();

            sb.append("#").append(cur++).append(" ");
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(a == 0){ // 합연산
                    union(b,c);
                }else{
                    if(find(b) == find(c)) sb.append("1");
                    else sb.append("0");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}