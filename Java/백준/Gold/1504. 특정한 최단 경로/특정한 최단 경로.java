import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, E, v1, v2;
    static int[] dist;

    static class node {
        int v;
        int w;

        node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static int dijkstra(int st, int ed){
        Arrays.fill(dist, INF);
        PriorityQueue<node> pq = new PriorityQueue<>(
                (o1, o2) -> o1.w - o2.w
        );

        dist[st] = 0;
        pq.offer(new node(st, 0));

        while(!pq.isEmpty()){
            node cur = pq.poll();

            if(dist[cur.v] < cur.w) continue;

            for(node n : graph.get(cur.v)){
                if(dist[n.v] <= dist[cur.v] + n.w) continue;
                dist[n.v] = dist[cur.v] + n.w;
                pq.offer(new node(n.v, dist[n.v]));
            }
        }

        return dist[ed];
    }

    static List<List<node>> graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList<>(N+1);
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        dist = new int[N+1];

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new node(b,w));
            graph.get(b).add(new node(a,w));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long path1 = (long)dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        long path2 = (long)dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        long ans = Math.min(path1, path2);
        System.out.println(ans >= INF ? -1 : ans);
    }
}