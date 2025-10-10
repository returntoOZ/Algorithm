import java.util.*;
import java.io.*;

public class Main {
    static class node{ int c, w; node(int c, int w){ this.c = c; this.w = w;} }

    static List<List<Integer>> graph;
    static int N, a, b;
    static int[] arr, dist;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        graph = new ArrayList<>(N+1);
        graph.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            int cur = arr[i];
            for(int j=i+cur; j<=N; j += cur){
                graph.get(i).add(j);
            }
            for(int j=i-cur; j>=1; j -= cur){
                graph.get(i).add(j);
            }
        }

        bfs();
    }

    static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(a);
        dist[a] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int n : graph.get(cur)){
                if(dist[cur] + 1 >= dist[n]) continue;
                dist[n] = dist[cur] + 1;

                if(n == b){
                    System.out.print(dist[n]);
                    return;
                }

                q.offer(n);
            }
        }

        System.out.print(-1);
    }
}