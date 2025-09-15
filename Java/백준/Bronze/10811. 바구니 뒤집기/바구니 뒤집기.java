import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;

    static void reverse(int to, int from){
        int[] tmp = Arrays.copyOf(arr, arr.length);

        int idx = from;
        for(int i=to; i<=from; i++){
            arr[i] = tmp[idx--];
        }
    }

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for(int i=1; i<=N; i++) arr[i] = i;
        
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
            reverse(a, b);
		}

        for(int i=1; i<=N; i++){
            sb.append(arr[i]).append(' ');
        }

        System.out.print(sb);
	}
}
