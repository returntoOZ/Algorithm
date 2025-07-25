import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, minTree, maxTree;

    static int minInit(int st, int ed, int node){
        if(st == ed) return minTree[node] = arr[st];
        int mid = (st + ed)/2;
        return minTree[node] = Math.min(minInit(st, mid, node * 2), minInit(mid + 1, ed, node * 2 + 1));
    }

    static int minSearch(int st, int ed, int node, int left, int right){
        if(right < st || ed < left) return Integer.MAX_VALUE;
        if(left <= st && ed <= right) return minTree[node];

        int mid = (st + ed)/2;
        return Math.min(minSearch(st, mid, node*2, left, right), minSearch(mid + 1, ed, node*2 + 1, left, right));
    }

    static int maxInit(int st, int ed, int node){
        if(st == ed) return maxTree[node] = arr[st];
        int mid = (st + ed)/2;
        return maxTree[node] = Math.max(maxInit(st, mid, node * 2), maxInit(mid + 1, ed, node * 2 + 1));
    }

    static int maxSearch(int st, int ed, int node, int left, int right){
        if(right < st || ed < left) return Integer.MIN_VALUE;
        if(left <= st && ed <= right) return maxTree[node];

        int mid = (st + ed)/2;
        return Math.max(maxSearch(st, mid, node*2, left, right), maxSearch(mid + 1, ed, node*2 + 1, left, right));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        minTree = new int[4*N];
        maxTree = new int[4*N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        minInit(0,N-1,1);
        maxInit(0,N-1,1);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = minSearch(0,N-1,1,a-1,b-1);
            int max = maxSearch(0,N-1,1,a-1,b-1);

            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}
