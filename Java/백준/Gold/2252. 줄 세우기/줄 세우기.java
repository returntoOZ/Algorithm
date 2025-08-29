import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] indegree;
    static boolean[] visited;
    static List<List<Integer>> graph;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(N+1);
        for(int i=0; i<N+1; i++) graph.add(new ArrayList<>());

        indegree = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            indegree[B]++;
            graph.get(A).add(B);
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            if(visited[cur]) continue;
            visited[cur] = true;
            sb.append(cur).append(" ");

            for(int node: graph.get(cur)){
                if(visited[node]) continue;
                if(--indegree[node] == 0) q.offer(node);
            }
        }

        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}
