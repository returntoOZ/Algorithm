import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt0 = 0, cnt1 = 0;
    static int[][] arr;

    static void recursion(int n, int r, int c){
        if(n == 1){
            if(arr[r][c] == 0) cnt0++;
            else cnt1++;
            return;
        }

        boolean flag = false;
        int cmp = arr[r][c];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(cmp == arr[r+i][c+j]) continue;
                flag = true; // 하나라도 불일치하는 것이 있을 때
            }
        }

        if(flag){
            int half = n/2;
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    recursion(half, r + i*half, c + j*half);
                }
            }
        }else{
            if(arr[r][c] == 0) cnt0++;
            else cnt1++;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(N, 0, 0);
        System.out.println(cnt0);
        System.out.println(cnt1);
    }
}
