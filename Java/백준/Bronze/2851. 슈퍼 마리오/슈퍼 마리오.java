import java.io.*;

public class Main {
    static int[] arr, sum;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[10];
        sum = new int[10];

        for(int i=0; i<10; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            if(i == 0) sum[i] = num;
            else sum[i] = sum[i-1] + num;
        }

        int cur = 101, ans=0;
        for(int i=0; i<10; i++){
            int gap = 100 - sum[i];

            if(cur >= Math.abs(gap)){
                cur = Math.abs(gap);
                ans = Math.max(ans, sum[i]);
            }
        }

        System.out.print(ans);
    }
}
