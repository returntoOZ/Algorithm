import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    static void bt(int cur){
        if(cur == M){ // 수열 완성
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(check[i]) continue;
            check[i] = true;
            arr[cur] = i;
            bt(cur+1);
            check[i] = false;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        check = new boolean[N+1];
        Arrays.fill(check, false);

        bt(0);
        System.out.print(sb);
    }
}
