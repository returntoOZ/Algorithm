import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

        int cnt = 0;
        for(int i=2; i<=N; i++){
            if(!isPrime[i]) continue;

            if(++cnt == K){
                System.out.print(i);
                return;
            }
            for(int j=i*i; j<=N; j += i){
                if(!isPrime[j]) continue;
                isPrime[j] = false;
                if(++cnt == K){
                    System.out.print(j);
                    return;
                }
            }
        }
    }
}