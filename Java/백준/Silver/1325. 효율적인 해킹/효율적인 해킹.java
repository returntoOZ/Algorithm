import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxV=-1;
    static List<Integer>[] graph;
    static int[] arr, check;

    static void bfs(int st){
        int cnt = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(st);
        check[st] = st;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int n : graph[cur]){
                if(check[n] == st) continue;
                check[n] = st;
                q.offer(n);
                cnt++;
            }
        }

        arr[st] = cnt;
        maxV = Math.max(maxV, cnt);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new int[N+1];
        arr = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }

        for(int i=1; i<=N; i++){
            bfs(i);
        }

        for(int i=1; i<=N; i++){
            if(arr[i] == maxV) sb.append(i).append(' ');
        }

        System.out.print(sb);
    }
}
