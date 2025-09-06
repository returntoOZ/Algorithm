import java.io.*;
import java.util.*;

public class Solution {
    static int T, cur=1;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static char[][] map;
    static char[] arr;
    static Set<Integer> set;
    // 4^6 = 2^12 = 4096    4096 * 2^4 = 2^16 대략 6.4만
    static void bt(int x, int y, int cnt){ // cnt 시작은 1
        if(cnt == 7){
            String st = "";
            for(int i=0; i<7; i++){
                st += arr[i];
            }
            set.add(Integer.valueOf(st));
            return;
        }

        arr[cnt] = map[x][y];

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;

            bt(nx, ny, cnt+1);
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-- >0){
            map = new char[4][4];
            arr = new char[7];
            set = new HashSet<>();

            for(int i=0; i<4; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++){
                    map[i][j] = st.nextToken().charAt(0);
                }
            }

            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    bt(i,j,0);
                }
            }

            sb.append("#").append(cur++).append(" ").append(set.size()).append("\n");
        }
        System.out.print(sb);
    }
}
