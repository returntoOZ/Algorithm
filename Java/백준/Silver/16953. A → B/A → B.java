import java.io.*;
import java.util.*;

public class Main {
    static class node {
        long next;
        int cnt;

        node(long next, int cnt){
            this.next = next;
            this.cnt = cnt;
        }
    }

    static int A,B;

    static void bfs(int start){
        Queue<node> q = new ArrayDeque<>();
        q.offer(new node(start, 1));

        while(!q.isEmpty()){
            node cur = q.poll();

            long first = cur.next * 2;
            if(first < B){
                q.offer(new node(first, cur.cnt+1));
            }else if(first == B){
                System.out.print(cur.cnt+1);
                return;
            }

            long second = cur.next * 10 + 1;
            if(second < B){
                q.offer(new node(second, cur.cnt+1));
            }else if(second == B){
                System.out.print(cur.cnt+1);
                return;
            }
        }
        System.out.print(-1);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        bfs(A);
    }
}
