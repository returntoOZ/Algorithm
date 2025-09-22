import java.util.*;
import java.io.*;

public class Main{
    static Queue<node> q = new ArrayDeque<>();
    static class node{
        int a;
        int b;
        int c;

        node(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static long[] dist;

    static boolean bellman_ford(int st){
        dist[st] = 0;

        for(int i=0; i<N-1; i++){
            for(node edge : q){
                int A = edge.a;
                int B = edge.b;
                int C = edge.c;
                if(dist[A] != Integer.MAX_VALUE && dist[A] + C < dist[B]){
                    dist[B] = dist[A] + C;
                }
            }
        }

        for(node edge : q){
            int A = edge.a;
            int B = edge.b;
            int C = edge.c;
            if(dist[A] != Integer.MAX_VALUE && dist[A] + C < dist[B]){
                return false;
            }
        }
        return true;
    }

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            q.offer(new node(A,B,C));
        }

        if(bellman_ford(1)){
            for(int i=2; i<= N; i++){
                if(dist[i] == Integer.MAX_VALUE){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(dist[i]).append("\n");
                }
            }
            System.out.print(sb);
            return;
        }
        System.out.print(-1);
    }
}
