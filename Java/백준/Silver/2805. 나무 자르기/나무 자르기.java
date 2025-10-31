import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] tree;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = -1, min = 0;

        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        int ans = 0;

        while(min <= max){
            long result = 0;
            int mid = (max + min) / 2;

            for(int i=0; i<N; i++){
                if(mid >= tree[i]) continue;
                result += (tree[i]-mid);
            }

            if(result >= M){
                ans = mid;
                min = mid + 1;
            }else if(result < M){
                max = mid - 1;
            }
        }

        System.out.print(ans);
    }
}
