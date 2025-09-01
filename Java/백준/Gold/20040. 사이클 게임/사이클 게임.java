import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;

    static void make(){
        for(int i=0; i<N; i++) parent[i] = i;
    }

    static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    static boolean union(int a, int b){
        int Ra = find(a);
        int Rb = find(b);

        if(Ra == Rb) return false; // 이때 중단임
        parent[Ra] = Rb;
        return true;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        make();

        int cnt = 0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cnt++;
            if(!union(a, b)){
                System.out.println(cnt);
                return;
            }
        }
        System.out.println(0);
    }
}
