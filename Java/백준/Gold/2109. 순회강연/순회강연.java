import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static PriorityQueue<Integer>[] list;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new PriorityQueue[10001];
        for(int i=0; i< 10001; i++) list[i] = new PriorityQueue<>(
            (o1, o2) -> o2 - o1
        );

        int maxDay = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            maxDay = Math.max(maxDay, d);
            list[d].offer(p);
        }

        int sum = 0;
        for(int i=maxDay; i>0; i--){
            int idx = 0, max = 0;

            boolean flag = true;
            for(int j=maxDay; j>=i; j--){
                if(list[j].isEmpty()) continue;
                if(max > list[j].peek()) continue;
                idx = j; max = list[idx].peek();
                flag = false;
            }

            if(flag) continue;

            sum += max; list[idx].poll();
        }

        System.out.print(sum);
    }
}