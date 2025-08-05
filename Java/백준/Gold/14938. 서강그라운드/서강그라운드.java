import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[] arr, dist;

    static List<List<node>> graph;

    static int dijkstra(int st){
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[st] = 0;
        PriorityQueue<node> pq = new PriorityQueue<>(
                (o1, o2) -> o1.w - o2.w
        );
        pq.offer(new node(st, 0));

        while(!pq.isEmpty()){
            node cur = pq.poll();

            if(dist[cur.v] < cur.w) continue;

            for(node n : graph.get(cur.v)){
                if(dist[n.v] <= dist[cur.v] + n.w) continue;
                //if(dist[cur.v] + n.w >= m) continue; // 수색 범위보다 크면 스킵
                dist[n.v] = dist[cur.v] + n.w;
                pq.offer(new node(n.v, dist[n.v]));
            }
        }

        int sum = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] > m) continue;
            sum += arr[i];
        }

        return sum;
    }

    static class node {
        int v;
        int w;

        node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        dist = new int[n+1];
        graph = new ArrayList<>(n+1);

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 각 구역의 아이템!
            graph.add(new ArrayList<>());
        }

        graph.add(new ArrayList<>());

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향 그래프!
            graph.get(a).add(new node(b,c));
            graph.get(b).add(new node(a,c));
        }

        int ans = -1;
        for(int i=1; i<=n; i++){
            ans = Math.max(ans, dijkstra(i));
        }

        System.out.print(ans);
    }
}
