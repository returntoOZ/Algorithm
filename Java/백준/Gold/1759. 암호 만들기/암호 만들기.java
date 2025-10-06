import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] arr;
    static StringBuilder sb;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        dfs(0, -1, 0, 0);
    }

    static void dfs(int cur, int prev, int mo, int ja){ // cur : 현재 갯수, prev : 이전 idx
        if(cur == L){
            if(mo >= 1 && ja >= 2) System.out.println(sb);
            return;
        }

        for(int i=prev+1; i<C; i++){
            sb.append(arr[i]);
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') dfs(cur+1, i, mo+1, ja);
            else dfs(cur+1, i, mo, ja+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
