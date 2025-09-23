import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        make();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0){
                union(b,c);
            }else{
                int Rb = find(b);
                int Rc = find(c);

                if(Rb == Rc) sb.append("yes\n");
                else sb.append("no\n");
            }
        }

        System.out.print(sb);
    }
}
