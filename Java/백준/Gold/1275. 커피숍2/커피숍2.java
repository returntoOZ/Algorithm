import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static long[] arr, segTree;

    static long init(int st, int ed, int node){
        if(st == ed) return segTree[node] = arr[st];

        int mid = (st+ed)/2;
        return segTree[node] = init(st, mid, node * 2) + init(mid+1, ed, node*2 + 1);
    }

    static long sum(int st, int ed, int node, int left, int right){
        if(right < st || ed < left) return 0;
        if(left <= st && ed <= right) return segTree[node];

        int mid = (st+ed)/2;
        return sum(st, mid, node*2, left, right) + sum(mid+1, ed, node*2+1, left, right);
    }

    static long update(int st, int ed, int node, int idx, int newValue){
        if(idx < st || ed < idx) return segTree[node];
        if(st == ed) return segTree[node] = newValue;

        int mid = (st + ed)/2;
        long left = update(st, mid, node*2, idx, newValue);
        long right = update(mid+1, ed, node*2 + 1, idx, newValue);
        return segTree[node] = left+right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new long[N];
        segTree = new long[4*N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(0, N-1, 1);

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(x < y) sb.append(sum(0, N-1, 1, x-1, y-1)).append("\n");
            else sb.append(sum(0, N-1, 1, y-1, x-1)).append("\n");
            update(0,N-1, 1, a-1,b);
        }

        System.out.print(sb);
    }
}
