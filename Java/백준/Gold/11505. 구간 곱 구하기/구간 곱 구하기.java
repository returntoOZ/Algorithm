import java.io.*;
import java.util.*;

public class Main {
    static final int div = 1000000007;
    static int N, M, K;
    static long[] arr, segTree;

    static long init(int st, int ed, int node){
        if(st == ed) return segTree[node] = arr[st];
        int mid = (st+ed)/2;
        return segTree[node] = (init(st, mid, node * 2)%div * init(mid + 1,ed, node * 2 + 1)%div)%div;
    }

    static long mul(int st, int ed, int node, int left, long right){
        if(right < st || ed < left) return 1;
        if(left <= st && ed <= right) return segTree[node];
        int mid = (st+ed)/2;
        return (mul(st, mid, node*2, left, right)%div * mul(mid+1, ed, node*2 + 1, left, right)%div)%div;
    }

    static long update(int st, int ed, int node, int idx, long change){
        if(idx < st || ed < idx) return segTree[node];
        if(st == ed) return segTree[node] = change;

        int mid = (st+ed)/2;
        long lValue = update(st, mid, node*2, idx, change);
        long rValue = update(mid + 1, ed, node*2 + 1, idx, change);
        return segTree[node] = (lValue%div * rValue%div)%div;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int leafCount = 1;
        while (leafCount < N) {
            leafCount <<= 1;
        }

        arr = new long[N];
        segTree = new long[leafCount * 2];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(0,N-1,1);

        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                update(0, N-1, 1, b-1, c);
            }else if(a == 2){
                sb.append(mul(0, N-1, 1, b-1, c-1)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
