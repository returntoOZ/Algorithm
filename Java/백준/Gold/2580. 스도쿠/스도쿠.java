import java.util.*;
import java.io.*;

public class Main {
    static class node{
        int x;
        int y;

        node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean solved = false;
    static int cnt = 0;
    static int[][] arr = new int[9][9];

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<node> q = new ArrayDeque<>();
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0){
                    cnt++; q.offer(new node(i,j));
                }
            }
        }

        node[] point = new node[cnt];
        for(int i=0; i<cnt; i++){
            point[i] = q.poll();
        }

        sudoku(0, point);
    }

    static node zone(int x, int y){
        if(x>=0 && x<=2){
            if(y>=0 && y<=2) return new node(0,0);
            else if(y>2 && y<=5) return new node(0,3);
            else return new node(0,6);
        }else if(x>2 && x<=5){
            if(y>=0 && y<=2) return new node(3,0);
            else if(y>2 && y<=5) return new node(3,3);
            else return new node(3,6);
        }else{
            if(y>=0 && y<=2) return new node(6,0);
            else if(y>2 && y<=5) return new node(6,3);
            else return new node(6,6);
        }
    }

    static void sudoku(int cur, node[] p){
        if(solved) return;
        if(cur == cnt){
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append("\n");
            }
            System.out.print(sb);
            solved = true;
            return;
        }

        node n = p[cur];
        int x = n.x;
        int y = n.y;

        boolean[] avil = new boolean[10];

        // 1. 가로줄 서치
        for(int i=0; i<9; i++){
            int v = arr[x][i];
            if(v==0) continue;
            avil[v] = true;
        }

        // 2. 세로줄 서치
        for(int i=0; i<9; i++){
            int v = arr[i][y];
            if(v==0) continue;
            avil[v] = true;
        }

        // 3. 3*3 서치
        node k = zone(x,y);
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int v = arr[k.x + i][k.y + j];
                if(v==0) continue;
                avil[v] = true;
            }
        }

        for(int i=1; i<=9; i++){
            if(avil[i]) continue;
            arr[x][y] = i;
            sudoku(cur+1, p);
            arr[x][y] = 0;
        }
    }
}
