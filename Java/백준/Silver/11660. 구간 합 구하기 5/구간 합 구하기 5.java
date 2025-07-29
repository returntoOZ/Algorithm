import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                sum += Integer.parseInt(st.nextToken());
                if(i==1 && j==1) arr[0][0] = sum;
                arr[i][j] = sum;
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = 0;
            for(int j=x1; j<=x2; j++){
                ans += (arr[j][y2]-arr[j][y1-1]);
            }
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
