import java.util.*;
import java.io.*;

public class Main {
    static int N, H, T;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> o2 - o1
        );

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            pq.offer(num);
        }

        int cnt = 0;
        while(T-- > 0){
            if(pq.peek() == 1){
                break;
            }

            if(pq.peek() < H){
                System.out.println("YES");
                System.out.println(cnt);
                return;
            }

            cnt++;
            int cur = pq.poll();
            pq.offer(cur/2);
        }

        if(pq.peek() < H){
            System.out.println("YES");
            System.out.println(cnt);
        }else{
            System.out.println("NO");
            System.out.println(pq.peek());
        }
    }
}
