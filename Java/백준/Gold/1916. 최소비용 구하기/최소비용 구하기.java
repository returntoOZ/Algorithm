import java.io.*;
import java.util.*;

public class Main {
    static int[] dist;
    static boolean[] check;

    static List<List<Node>> graph;

    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static void dijkstra(int st) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(check, false);
        dist[st] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1.weight, o2.weight)
        );
        pq.add(new Node(st, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.to;

            if(check[node]) continue; // 방문한 곳이면 skip
            check[node] = true;

            for(Node n : graph.get(node)) {
                int v = n.to, w = n.weight;
                if(!check[v] && dist[v] > dist[node] + w) {
                    dist[v] = dist[node] + w;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[N+1]; // 거리 업데이트
        check = new boolean[N+1]; // 방문 여부 체크
        
        StringTokenizer st;
        for(int i = 0; i < M; i++) { // a -> b로 이동할 때, 가중치 w
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, w));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);
    }
}
