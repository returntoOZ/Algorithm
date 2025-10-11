import java.io.*;
import java.util.*;

public class Main {
    static class node{int vertex; int weight; node(int vertex, int weight){this.vertex = vertex; this.weight = weight;}}
    static int n, m, start, end;
    static int[] dist, prev;
    static ArrayList<ArrayList<node>> graph;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1];
        prev = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        graph = new ArrayList<>(n+1);
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new node(b,c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        Stack<Integer> s = new Stack<>();
        s.push(end);

        while(true){
            if(s.peek() == start) break;
            s.push(prev[s.peek()]);
        }

        sb.append(dist[end]).append("\n");
        sb.append(s.size()).append("\n");
        while(!s.isEmpty()){
            sb.append(s.pop()).append(' ');
        }

        System.out.print(sb);
    }

    static void dijkstra(){
        PriorityQueue<node> pq = new PriorityQueue<>(
                (o1, o2) -> o1.weight - o2.weight
        );
        
        pq.offer(new node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            node cur = pq.poll();
            
            if(cur.vertex == end) break;
            for(node n : graph.get(cur.vertex)){
                if(dist[n.vertex] <= dist[cur.vertex] + n.weight) continue;
                dist[n.vertex] = dist[cur.vertex] + n.weight;
                pq.offer(new node(n.vertex, dist[n.vertex]));
                prev[n.vertex] = cur.vertex;
            }
        }
    }
}
