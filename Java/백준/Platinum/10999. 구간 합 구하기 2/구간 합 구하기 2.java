import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] arr, segTree, lazy;

    static long init(int st, int ed, int node){
        if(st == ed) return segTree[node] = arr[st];

        int mid = (st+ed)/2;
        return segTree[node] = init(st, mid, node*2) + init(mid+1, ed, node*2+1);
    }

    static void lazy_update(int st, int ed, int node){
        if(lazy[node] == 0) return;
        segTree[node] += (ed-st+1)*lazy[node];

        if(st != ed){
            lazy[node*2] += lazy[node];
            lazy[node*2+1] += lazy[node];
        }
        lazy[node] = 0;
    }

    // 구간 갱신
    static void range_update(int st, int ed, int node, int left, int right, long newValue){
        lazy_update(st, ed, node);

        if(right < st || ed < left) return;

        if(left <= st && ed <= right){
            segTree[node] += (ed-st+1)*newValue;

            if(st != ed){
                lazy[node*2] += newValue;
                lazy[node*2+1] += newValue;
            }
            return;
        }

        int mid = (st+ed)/2;
        range_update(st, mid, node*2, left, right, newValue);
        range_update(mid+1, ed, node*2+1, left, right, newValue);
        segTree[node] = segTree[node*2] + segTree[node*2+1];
    }

    static long query(int st, int ed, int node, int left, int right){
        lazy_update(st, ed, node);

        if(right < st || ed < left) return 0;
        if(left <= st && ed <= right) return segTree[node];

        int mid = (st+ed)/2;
        return query(st, mid, node*2, left, right) + query(mid+1, ed, node*2+1, left, right);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        segTree = new long[4*N];
        lazy = new long[4*N];

        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.fill(lazy, 0);
        init(0,N-1,1);

        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){ // 구간 업데이트
                long d = Long.parseLong(st.nextToken());
                range_update(0,N-1,1,b-1,c-1, d);
            }else if(a == 2){ // 구간 합
                sb.append(query(0,N-1,1,b-1,c-1)).append("\n");
            }
        }

        System.out.print(sb);
    }
}

