import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, segTree;

    static int init(int st, int ed, int node){
        if(st == ed) return segTree[node] = st;

        int mid = (st+ed)/2;

        int left = init(st, mid, node*2);
        int right = init(mid+1, ed, node*2+1);
        if(arr[left] <= arr[right]) return segTree[node] = left;
        else return segTree[node] = right;
    }

    static int search(int st, int ed, int node, int left, int right){
        if(right < st || ed < left) return N;
        if(left <= st && ed <= right) return segTree[node];

        int mid = (st+ed)/2;
        int lv = search(st, mid, node*2, left, right);
        int rv = search(mid+1, ed, node*2 + 1, left, right);
        if(arr[lv] <= arr[rv]) return lv;
        else return rv;
    }

    static int update(int st, int ed, int node, int idx){
        if(idx < st || ed < idx) return segTree[node];
        if(st == ed) return segTree[node];

        int mid = (st+ed)/2;
        int left = update(st, mid, node*2, idx);
        int right = update(mid+1, ed, node*2 + 1, idx);
        if(arr[left] <= arr[right]) return segTree[node] = left;
        else return segTree[node] = right;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int treeSize = 1;

        while(treeSize < N){
            treeSize <<=1;
        }
        treeSize *= 2;

        arr = new int[N+1];
        arr[N] = Integer.MAX_VALUE;

        segTree = new int[4*N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(0, N-1, 1);

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==1){
                arr[b-1] = c;
                update(0,N-1, 1, b-1);
            }else if(a==2){
                sb.append(search(0,N-1, 1, b-1, c-1) + 1).append("\n");
            }
        }

        System.out.print(sb);
    }
}
