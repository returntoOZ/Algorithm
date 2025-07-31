import java.io.*;
import java.util.*;

public class Main {
    static int N,M,R;
    static int[][] arr;

    static void rotate(int x, int y, int w, int h){
        int rotateCnt = R % ((w+h-2) * 2); // 실제 회전 수

        // (y,x)가 회전의 시작 위치
        // x길이 : w  y길이 : h

        for(int k=0; k<rotateCnt; k++){
            int tmp = arr[y][x];
            // 1) 상단 x축
            for(int i=0; i<w-1; i++){
                arr[y][x+i] = arr[y][x+i+1];
            }
            // 2) 우측 y축
            for(int i=0; i<h-1; i++){
                arr[y+i][x+w-1] = arr[y+i+1][x+w-1];
            }
            // 3) 하단 x축
            for(int i=w-1; i>0; i--){
                arr[y+h-1][x+i] = arr[y+h-1][x+i-1];
            }
            // 4) 좌측 y축
            for(int i=h-1; i>1; i--){
                arr[y+i][x] = arr[y+i-1][x];
            }
            // 5) 초기 위치 할당
            arr[y+1][x] = tmp;
        }

        if(w==2 || h==2) return;

        rotate(x+1, y+1, w-2, h-2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotate(0,0,M,N);
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
