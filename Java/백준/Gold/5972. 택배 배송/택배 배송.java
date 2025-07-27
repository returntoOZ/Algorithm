import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;

    static int[] dist;
    static boolean[] visited;
    static List<List<Node>> graph;

    static class Node {
        int v;
        int w;

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static void dijkstra(int start){
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1.w, o2.w)
        );

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.v]) continue;
            visited[cur.v] = true;

            for(Node n : graph.get(cur.v)){
                if(!visited[n.v] && dist[n.v] > dist[cur.v] + n.w){
                    dist[n.v] = dist[cur.v] + n.w;
                    pq.add(new Node(n.v, dist[n.v]));
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        visited = new boolean[N+1];
        graph = new ArrayList<>(N+1);
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        dijkstra(1);
        System.out.print(dist[N]);
    }
}
