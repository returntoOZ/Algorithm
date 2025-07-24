import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr, segTree;

    static long init(int st, int ed, int node){ // 세그먼트 트리를 초기화하는 함수
        // st: 시작 idx, ed: 마지막 idx, node: 세그먼트 트리의 현재 노드
        if(st == ed) return segTree[node] = arr[st];
        int mid = (st+ed)/2;
        return segTree[node] = init(st, mid, node*2) + init(mid+1, ed, node*2 + 1);
    }

    static long sum(int st, int ed, int node, long left, long right){
        // left: 구간 합을 구할 idx의 시작 위치, right: 구간 합을 구할 idx의 마지막 위치
        if(right < st || ed < left) return 0;
        if(left <= st && ed <= right) return segTree[node];
        int mid = (st+ed)/2;
        return sum(st, mid, node *2, left, right) + sum(mid+1, ed, node *2 + 1, left, right);
    }

    static long update(int st, int ed, int node, int idx, long change){
        if(idx < st || ed < idx) return segTree[node];
        if(st == ed) return segTree[node] = change;

        int mid = (st+ed)/2;
        long lvalue = update(st, mid, node *2, idx, change);
        long rvalue = update(mid + 1, ed, node *2+1, idx, change);
        return segTree[node] = lvalue + rvalue;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int leafCount = 1;
        while (leafCount < N) {
            leafCount <<= 1;
        }
        
        arr= new long[N]; // 숫자 배열, idx : 0 ~ N-1
        segTree = new long[leafCount * 2];

        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        init(0,N-1,1);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                update(0, N-1, 1, b-1, c);
            }else if(a == 2){
                sb.append(sum(0, N-1, 1,b-1,c-1)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
