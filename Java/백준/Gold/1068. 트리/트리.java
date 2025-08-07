import java.io.*;
import java.util.*;

public class Main {
    static int N, del, start, cnt = 0;
    static int[] parent;
    static List<List<Integer>> tree;

    static void bfs(int root){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int cur = q.poll();

            if(tree.get(cur).isEmpty()) { // 리프 노드이면 개수 증가, 탐색 중단
                cnt++;
                continue;
            }

            boolean flag = true;
            for(int nxt : tree.get(cur)){
                if(parent[cur] == nxt) continue; // 자신의 부모는 방문안함
                if(parent[nxt] == del || nxt == del) continue; // 삭제된 부모거나, 삭제된 부모의 자식이거나
                q.offer(nxt);
                flag = false;
            }
            
            if(flag) cnt++;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        tree = new ArrayList<>(N);
        for(int i=0; i<N; i++){
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            parent[i] = num;

            if(num == -1) {
                start = i;
                continue;
            }
            tree.get(num).add(i);
        }

        del = Integer.parseInt(br.readLine());

        if(parent[del] == -1){ // 루트를 삭제하는 경우
            System.out.print(0);
            return;
        }

        bfs(start);
        System.out.print(cnt);
    }
}