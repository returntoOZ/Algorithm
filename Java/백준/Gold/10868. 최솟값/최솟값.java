import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, segTree;

    static int init(int st, int ed, int node){
        if(st == ed) return segTree[node] = arr[st];

        int mid = (st + ed) / 2;
        return segTree[node] = Math.min(init(st, mid, node * 2), init(mid+1, ed, node*2+1));
    }

    static int search(int st, int ed, int node, int left, int right){
        if(right < st || ed < left) return Integer.MAX_VALUE;
        if(left <= st && ed <= right) return segTree[node];

        int mid = (st + ed) / 2;
        return Math.min(search(st, mid, node*2, left, right), search(mid+1, ed, node*2 +1,left, right));
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        segTree = new int[N*4];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(0, N-1, 1);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(search(0,N-1, 1, a-1, b-1)).append("\n");
        }
        System.out.print(sb);
    }
}
