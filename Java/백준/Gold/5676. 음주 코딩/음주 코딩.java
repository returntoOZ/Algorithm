import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr, segTree;

    static int init(int st, int ed, int node){
        if(st == ed) return segTree[node] = arr[st];

        int mid = (st+ed)/2;
        return segTree[node] = init(st, mid, node*2) * init(mid+1, ed, node*2+1);
    }

    static int update(int st, int ed, int node, int idx, int newValue){
        if(idx < st || ed < idx) return segTree[node];
        if(st == ed) return segTree[node] = newValue;

        int mid = (st+ed)/2;
        int left = update(st, mid, node*2, idx, newValue);
        int right = update(mid+1, ed, node*2 + 1, idx, newValue);
        return segTree[node] = left * right;
    }

    static int search(int st, int ed, int node, int left, int right){
        if(right < st || ed < left) return 1;
        if(left <= st && ed <= right) return segTree[node];

        int mid = (st+ed)/2;
        int lv = search(st, mid, node*2, left, right);
        int rv = search(mid+1, ed, node*2 + 1, left, right);
        return lv * rv;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while((input = br.readLine()) != null){
            input = input.trim();
            if (input.isEmpty()) break;

            StringTokenizer st = new StringTokenizer(input);
            StringBuilder sb = new StringBuilder();

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];
            segTree = new int[4*N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int num = Integer.parseInt(st.nextToken());
                if(num > 0) arr[i] = 1;
                else if(num < 0) arr[i] = -1;
                else arr[i] = 0;
            }

            init(0,N-1,1);

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine().trim());
                char a = st.nextToken().charAt(0);
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(a == 'C'){
                    if(c > 0){
                        if(arr[b-1] == 1) continue;
                        arr[b-1] = 1;
                        update(0,N-1, 1, b-1, 1);
                    }
                    else if(c<0){
                        if(arr[b-1] == -1) continue;
                        arr[b-1] = -1;
                        update(0,N-1, 1, b-1, -1);
                    }else{
                        if(arr[b-1] == 0) continue;
                        arr[b-1] = 0;
                        update(0,N-1, 1, b-1, 0);
                    }
                }else if(a == 'P'){
                    int value = search(0,N-1, 1, b-1, c-1);

                    if(value > 0) sb.append("+");
                    else if(value < 0) sb.append("-");
                    else sb.append("0");
                }
            }
            sb.append("\n");
            System.out.print(sb);
        }
    }
}
