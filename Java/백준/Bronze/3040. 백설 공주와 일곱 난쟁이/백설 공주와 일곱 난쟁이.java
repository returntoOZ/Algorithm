import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] check;
    static int sum = 0;

    static StringBuilder sb = new StringBuilder();

    static void combination(int cur, int cmp, int prev){
        if(cur == 2){
            if(sum-cmp == 100){
                for(int i=0; i<9; i++){
                    if(check[i]) continue;
                    sb.append(arr[i]).append("\n");
                }
                return;
            }
        }

        for(int i=prev; i<9; i++){
            if(check[i]) continue;
            check[i] = true;
            combination(cur+1, cmp+arr[i], i+1);
            check[i] = false;
        }
    }

    static void powerset(int cnt, int idx, int sum){
        if(cnt == 7){
            if(sum == 100){
                for(int i=0; i<9; i++){
                    if(check[i]) sb.append(arr[i]).append("\n");
                }
                System.out.print(sb);
                return;
            }

        }

        if(idx >= 9) return;

        check[idx] = true;
        powerset(cnt+1, idx+1, sum + arr[idx]);
        check[idx] = false;
        powerset(cnt, idx+1, sum);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];
        check = new boolean[9];
        Arrays.fill(check, false);

        for(int i=0; i<9; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
        }

        // 1번 풀이
        // 9개 중에 2개 뽑기
//        combination(0,0, 0);
//        System.out.print(sb);
        // 2번 풀이
        // 7개짜리 부분 집합 만들기
        powerset(0,0, 0);
    }
}
