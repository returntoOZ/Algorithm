import java.io.*;
import java.util.*;

public class Main {
    static final int limit = 100000;
    static int N, K;
    static int[] dist;

    static class Node {
        int v;
        int w;

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static void dijkstra(int st){
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (o1, o2) -> o1.w - o2.w
        );

        pq.offer(new Node(st, 0));
        dist[st] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            int first = cur.v + 1;
            int second = cur.v - 1;
            int third = cur.v * 2;

            if(third == K){
                if(dist[third] > dist[cur.v]) dist[third] = dist[cur.v];
            }else if(third <= limit){
                if(dist[third] > dist[cur.v]){
                    pq.offer(new Node(third, cur.w));
                    dist[third] = dist[cur.v];
                }
            }

            if(first == K){
                if(dist[first] > dist[cur.v] + 1) dist[first] = dist[cur.v] + 1;
            }else if(first <= limit){ // 범위 내에 있는 지부터!
                if(dist[first] > dist[cur.v] + 1){
                    pq.offer(new Node(first, cur.w + 1));
                    dist[first] = dist[cur.v] + 1;
                }
            }

            if(second == K){
                if(dist[second] > dist[cur.v] + 1) dist[second] = dist[cur.v] + 1;
            }else if(second >= 0){
                if(dist[second] > dist[cur.v] + 1){
                    pq.offer(new Node(second, cur.w + 1));
                    dist[second] = dist[cur.v] + 1;
                }
            }
        }
        System.out.print(dist[K]);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[limit + 1];
        dijkstra(N);
    }
}
