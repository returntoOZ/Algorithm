import java.io.*;
import java.util.*;
public class Solution {
    static int[][] arr = new int[100][100];
    static boolean[][] visited = new boolean[100][100];
    static int[] dy = {1,-1,0};
    static int[] dx = {0,0,-1};
    static int x, y;
    static int search(int x, int y){
        int curx = x;
        int cury = y;
        visited[x][y] = true;
        while(curx != 0){
            for(int i=0; i<3; i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;
                if(arr[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                curx = nx;
                cury = ny;
                break;
            }
        }
        return cury;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        while(T-- > 0){
            StringBuilder sb = new StringBuilder();
            int cur = Integer.parseInt(br.readLine());
            sb.append("#").append(cur).append(' ');
            for(int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    visited[i][j] = false;
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                    if(num == 2){
                        x = i;
                        y = j;
                    }
                }
            }
            sb.append(search(x,y)).append("\n");
            System.out.print(sb);
        }
    }
}