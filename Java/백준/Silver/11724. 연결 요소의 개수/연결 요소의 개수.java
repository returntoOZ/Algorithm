import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cnt = 0;
    static boolean[] check;
    static List<List<Integer>> graph;

    static void bfs(int st){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(st);
        check[st] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int node : graph.get(cur)){
                if(check[node]) continue;
                check[node] = true;
                q.offer(node);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N+1];
        Arrays.fill(check, false);
        graph = new ArrayList<>(N+1);
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1; i<=N; i++){
            if(check[i]) continue;
            bfs(i);
            cnt++;
        }

        System.out.print(cnt);
    }
}
