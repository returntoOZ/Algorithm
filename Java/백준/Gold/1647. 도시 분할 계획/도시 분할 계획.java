import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int to;
    int weight;

    public Node(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n){
        return this.weight - n.weight;
    }
}

public class Main {
    static int N, M;
    static boolean[] check;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static List<List<Node>> graph;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N+1];
        graph = new ArrayList<>(N+1);
        for(int i=0; i<N+1; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B,C));
            graph.get(B).add(new Node(A,C));
        }

        int sum=0, cnt = 0, maxWeight=-1;

        pq.offer(new Node(1,0));

        while(!pq.isEmpty()){
            if(cnt == N) break;

            Node cur = pq.poll();
            if(check[cur.to]) continue;
            check[cur.to] = true;
            cnt++;

            sum += cur.weight;
            maxWeight = Math.max(maxWeight, cur.weight);

            for(Node n: graph.get(cur.to)){
                if(check[n.to]) continue;
                pq.offer(n);
            }
        }
        System.out.print(sum-maxWeight);
    }
}
