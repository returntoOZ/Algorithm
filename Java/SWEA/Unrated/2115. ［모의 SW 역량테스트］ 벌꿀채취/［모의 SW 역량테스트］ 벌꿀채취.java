import java.io.*;
import java.util.*;

public class Solution {
    static int T, N, M, C, order=1, max;
    static int[][] arr;

    static void subset(int cur, int[] comb, boolean[] check){
        if(cur == M){
            int sum = 0, powSum = 0;
            for(int i=0; i<M; i++){
                if(check[i]){
                    sum += comb[i];
                    powSum += Math.pow(comb[i],2);
                }
            }
            if(sum > C) return;
            max = Math.max(max, powSum);
        }

        for(int i=cur; i<M; i++){
            check[i] = true;
            subset(cur+1, comb, check);
            check[i] = false;
            subset(cur+1, comb, check);
        }
    }

    static int search(){
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<N; i++){
            int mmax = -1; // 각 라인 별 최대
            for(int j=0; j<N-M+1; j++){
                // 시작점 (i,j)
                int[] comb = new int[M];
                boolean[] check = new boolean[M];

                int cSum = 0, pSum = 0;
                boolean flag = false;
                max = -1;

                for(int k=0; k<M; k++){ // M개의 벌통
                    int val = arr[i][j+k];
                    comb[k] = val;
                    cSum += val;
                    pSum += Math.pow(val,2);

                    if(cSum > C) flag = true;
                }

                if(flag){ // M개의 합이 C를 넘을 경우, M개 중에서 C를 안넘는 최고의 조합을 찾아야함
                    subset(0, comb, check);
                    mmax = Math.max(mmax, max);
                }else{
                    mmax = Math.max(mmax, pSum);
                }
            }
            ans.add(mmax);
        }

        Collections.sort(ans, Collections.reverseOrder());
        return ans.get(0) + ans.get(1);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while(T-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            arr = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int val = search();
            sb.append("#").append(order++).append(" ").append(val).append("\n");
        }

        System.out.print(sb);
    }
}
