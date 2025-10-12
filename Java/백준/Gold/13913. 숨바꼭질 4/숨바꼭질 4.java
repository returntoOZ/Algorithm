import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] check, prev;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        check = new int[100001];
        Arrays.fill(check, Integer.MAX_VALUE);
        prev = new int[100001];

        bfs();
        sb.append(check[K]).append("\n");

        Stack<Integer> s = new Stack<>();
        s.push(K);
        while(true){
            if(s.peek() == N) break;
            s.push(prev[s.peek()]);
        }

        while(!s.empty()){
            sb.append(s.pop()).append(' ');
        }
        System.out.print(sb);
    }

    static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        check[N] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == K) return;

            // -1
            int n1 = cur - 1;
            if(n1 >= 0 && check[n1] > check[cur]+1){
                check[n1] = check[cur] + 1;
                prev[n1] = cur;
                q.offer(n1);
            }

            // +1
            int n2 = cur + 1;
            if(n2 <= 100000 && check[n2] > check[cur]+1){
                check[n2] = check[cur] + 1;
                prev[n2] = cur;
                q.offer(n2);
            }

            // *2
            int n3 = cur * 2;
            if(n3 <= 100000 && check[n3] > check[cur]+1){
                check[n3] = check[cur] + 1;
                prev[n3] = cur;
                q.offer(n3);
            }
        }
    }
}
