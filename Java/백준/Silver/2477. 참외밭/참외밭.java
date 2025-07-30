import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int totalW = -1;
        int totalH = -1;

        int[] arr = new int[6];
        int[][] order = {
                {1,4,2,3},
                {2,3,1,4},
                {3,1,4,2},
                {4,2,3,1}
        };

        int curDir = 0, idx = 0;
        boolean flag = true;
        for(int i=0; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = w;
            if(i == 0) {
                if(dir == 1) curDir = 0;
                else if(dir == 2) curDir = 1;
                else if(dir == 3) curDir = 2;
                else if(dir == 4) curDir = 3;
            }

            if(flag && order[curDir][i%4] != dir) {
                idx = i;
                flag = false;
            }

            if(dir == 3 || dir == 4) {
                totalW = Math.max(totalW, w);
            }else {
                totalH = Math.max(totalH, w);
            }
        }

        int minus;
        if(idx == 0) {
            minus = arr[0] * arr[5];
        }
        else {
            minus = arr[idx] * arr[idx-1];
        }
        int ans = (totalW * totalH) - minus;
        ans *= K;

        System.out.print(ans);
    }
}
