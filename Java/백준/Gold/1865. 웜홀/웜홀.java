import java.io.*;
import java.util.*;

public class Main {
    static int TC, N, M, W;
    static int[] dist;
    static List<edge> edges;

    static class edge{
        int a;
        int b;
        int w;

        edge(int a, int b, int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    static boolean bellman_ford(int st){
        dist[st] = 0;

        for(int i=0; i<N-1; i++){
            for(edge e : edges){
                int cur = e.a, next = e.b, w = e.w;

                if(dist[cur] + w < dist[next]){
                    dist[next] = dist[cur] + w;
                }
            }
        }

        for(edge e : edges){
            int cur = e.a, next = e.b, w = e.w;

            if(dist[cur] + w < dist[next]){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());

        while(TC-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N+1];
            edges = new ArrayList<>();

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edges.add(new edge(S,E,T));
                edges.add(new edge(E,S,T));
            }

            for(int i=0; i<W; i++){
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                T *= -1;
                edges.add(new edge(S,E,T));
            }

            if(bellman_ford(1)) sb.append("NO\n");
            else sb.append("YES\n");
        }

        System.out.print(sb);
    }
}
