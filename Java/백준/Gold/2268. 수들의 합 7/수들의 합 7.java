import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] arr, segTree;

    static long sum (int st, int ed, int node, int left, int right){
        if(right < st || ed < left) return 0;
        if(left <= st && ed <= right) return segTree[node];

        int mid = (st+ed)/2;
        long lvalue = sum(st, mid, node*2, left, right);
        long rvalue = sum(mid + 1, ed, node*2 +1, left, right);
        return lvalue + rvalue;
    }

    static long update(int st, int ed, int node, int idx, int newValue){
        if(idx < st || ed < idx) return segTree[node];
        if(st == ed) return segTree[node] = newValue;

        int mid = (st+ed)/2;
        long left = update(st, mid, node*2, idx, newValue);
        long right = update(mid+1, ed, node*2+1, idx, newValue);
        return segTree[node] = left + right;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N];
        segTree = new long[4*N];

        Arrays.fill(segTree, 0);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==0){
                if(b < c){
                    sb.append(sum(0,N-1,1, b-1, c-1)).append("\n");
                }
                else{
                    sb.append(sum(0,N-1,1, c-1, b-1)).append("\n");
                }
            }else if(a==1){
                update(0,N-1,1,b-1,c);
            }
        }

        System.out.print(sb);
    }
}
