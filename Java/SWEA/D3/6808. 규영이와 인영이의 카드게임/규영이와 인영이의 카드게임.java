import java.io.*;
import java.util.*;

public class Solution {
    // 백트래킹
    static int T, kyu, in, cnt = 1;
    static int[] arr1, arr2, cmp;
    static boolean[] check, total;

    static void bt(int cur){
        if(cur == 9) {
            int sum1 = 0, sum2 = 0;
            for(int i=0; i<9; i++){ // 게임
                if(arr1[i] > cmp[i]){
                    sum1 += (arr1[i] + cmp[i]);
                }else if(arr1[i] < cmp[i]){
                    sum2 += (arr1[i] + cmp[i]);
                }
            }

            if(sum1 > sum2) kyu++;
            else if(sum1 < sum2)in++;
            return;
        }

        for(int i=0; i<9; i++){
            if(check[i]) continue;
            check[i] = true;
            cmp[cur] = arr2[i];
            bt(cur+1);
            check[i] = false;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        arr1 = new int[9]; // 규영
        arr2 = new int[9]; // 인영
        cmp = new int[9];
        check = new boolean[9];
        total = new boolean[19];

        while(T-- > 0){
            Arrays.fill(check, false);
            Arrays.fill(total, false);

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<9; i++){
                int num = Integer.parseInt(st.nextToken());
                total[num] = true;
                arr1[i] = num;
            }

            int idx = 0;
            for(int i=1; i<=18; i++){
                if(total[i]) continue;
                arr2[idx++] = i;
            }

            kyu = 0; // 규영이 이긴 횟수
            in = 0; // 인영이 이긴 횟수

            sb.append("#").append(cnt++).append(" ");
            bt(0);
            sb.append(kyu).append(" ").append(in).append("\n");
        }
        System.out.print(sb);
    }
}