import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, minTree;

    static int init(int st, int ed, int node){
        if(st == ed) return minTree[node] = arr[st];

        int mid = (st+ed)/2;
        return minTree[node] = Math.min(init(st, mid, node*2), init(mid+1, ed, node*2 + 1));
    }

    static int search(int st, int ed, int node, int left, int right){
        if(right < st || ed < left) return Integer.MAX_VALUE;
        if(left <= st && ed <= right) return minTree[node];

        int mid = (st+ed)/2;
        return Math.min(search(st, mid, node*2, left, right), search(mid+1, ed, node*2 + 1, left, right));
    }

    static int update(int st, int ed, int node, int idx, int newValue){
        if(idx < st || ed < idx) return minTree[node];
        if(st == ed) return minTree[node] = newValue;

        int mid = (st+ed)/2;
        int left = update(st, mid, node*2, idx, newValue);
        int right = update(mid+1, ed, node*2 + 1, idx, newValue);
        return minTree[node] = Math.min(left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int treeSize = 1;
        while(treeSize < N){
            treeSize <<= 1;
        }
        treeSize *= 2;

        arr = new int[N];
        minTree = new int[treeSize];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(0, N-1, 1);

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(type==1){ // update
                update(0, N-1, 1, a-1, b);
            }else if(type==2){ // search
                sb.append(search(0, N-1, 1, a-1, b-1)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
