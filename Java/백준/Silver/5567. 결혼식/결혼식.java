import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] check;
    static List<List<Integer>> graph;

    static class node{
        int v;
        int w;

        node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static int bfs(int st){
        Arrays.fill(check, false);
        Queue<node> q = new ArrayDeque<>();
        q.offer(new node(st, 0));
        check[st] = true;

        int cnt = 0;
        while(!q.isEmpty()){
            node cur = q.poll();

            for(int nxt : graph.get(cur.v)){
                if(check[nxt]) continue;
                if(cur.w + 1 > 2) continue;
                check[nxt] = true;
                q.offer(new node(nxt, cur.w + 1));
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        check = new boolean[n+1];
        graph = new ArrayList<>(n+1);
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.print(bfs(1));
    }
}
