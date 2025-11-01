import java.util.*;
import java.io.*;

public class Main {
    static int K, N;
    static int[] lan;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lan = new int[K];

        long min = 1, max = -1;

        for(int i=0; i<K; i++){
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lan[i]);
        }

        long ans = 0;
        while(min <= max){
            long mid = (min+max)/2;
            long cnt = 0;

            for(int i=0; i<K; i++){
                cnt += (lan[i]/mid);
            }

            if(cnt >= N){
                ans = mid;
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }

        System.out.print(ans);
    }
}
