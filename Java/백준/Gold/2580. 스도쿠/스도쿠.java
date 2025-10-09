import java.util.*;
import java.io.*;

public class Main {
    static class node{
        int x, y;
        node(int x, int y){ this.x = x; this.y = y; }
    }

    static boolean solved = false;
    static int[][] arr = new int[9][9];
    static List<node> list = new ArrayList<>();
    static boolean[][] rowUsed = new boolean[9][10];
    static boolean[][] colUsed = new boolean[9][10];
    static boolean[][] boxUsed = new boolean[9][10];

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                int v = arr[i][j];
                if(v == 0){
                    list.add(new node(i,j));
                }else{
                    rowUsed[i][v] = true;
                    colUsed[j][v] = true;
                    int zone = (i/3) * 3 + (j/3);
                    boxUsed[zone][v] = true;
                }
            }
        }

        sudoku(0);
    }

    static void sudoku(int cur){
        if(solved) return;
        if(cur == list.size()){
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

        node n = list.get(cur);
        int x = n.x, y = n.y;
        int box = (x/3)*3 + (y/3);

        for(int i=1; i<=9; i++){
            if(rowUsed[x][i] || colUsed[y][i] || boxUsed[box][i]) continue;

            arr[x][y] = i;
            rowUsed[x][i] = colUsed[y][i] = boxUsed[box][i] = true;

            sudoku(cur+1);
            if(solved) return;

            arr[x][y] = 0;
            rowUsed[x][i] = colUsed[y][i] = boxUsed[box][i] = false;
        }
    }
}
