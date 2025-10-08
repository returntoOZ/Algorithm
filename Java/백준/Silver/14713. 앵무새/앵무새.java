import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        ArrayDeque<String>[] q = new ArrayDeque[N];

        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split(" ");
            q[i] = new ArrayDeque<>();
            for(int j=0; j<arr.length; j++){
                q[i].offer(arr[j]);
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
        }

        String[] cmp = br.readLine().split(" ");
        for(int i=0; i<cmp.length; i++){
            map.put(cmp[i], map.getOrDefault(cmp[i], 0) - 1);
            if(map.get(cmp[i]) == -1){
                System.out.print("Impossible");
                return;
            }
            for(int j=0; j<N; j++){
                if(q[j].isEmpty()) continue;
                if(q[j].peek().equals(cmp[i])) {
                    q[j].poll();
                    break;
                }
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
