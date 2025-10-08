import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ArrayDeque<String>[] q = new ArrayDeque[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            q[i] = new ArrayDeque<>();
            while(st.hasMoreTokens()) q[i].offer(st.nextToken());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());


        while(st.hasMoreTokens()) {
            String cur = st.nextToken();
            boolean flag = true;

            for(int i=0; i<N; i++){
                if(q[i].isEmpty()) continue;
                if(q[i].peek().equals(cur)) {
                    q[i].poll();
                    flag = false;
                    break;
                }
            }

            if(flag){
                System.out.print("Impossible");
                return;
            }
        }

        for(Queue a : q){
            if(a.isEmpty()) continue;
            System.out.print("Impossible");
            return;
        }
        System.out.print("Possible");
    }
}
