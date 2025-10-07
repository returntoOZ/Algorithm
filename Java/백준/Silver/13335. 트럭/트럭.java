import java.io.*;
import java.util.*;

public class Main {
    static int n, w, L;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Queue<Integer> bridge = new ArrayDeque<>(), truck = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) truck.add(Integer.parseInt(st.nextToken()));
        for(int i=0; i<w; i++) bridge.add(0);

        int cur = 0, time = 0;

        while(!bridge.isEmpty()){
            time++;
            cur -= bridge.poll();

            if(truck.isEmpty()) continue;

            if(cur + truck.peek() > L) bridge.add(0);
            else{
                cur += truck.peek();
                bridge.add(truck.poll());
            }
        }

        System.out.print(time);
    }
}
