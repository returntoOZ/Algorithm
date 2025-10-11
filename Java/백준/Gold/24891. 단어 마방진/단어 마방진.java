import java.util.*;
import java.io.*;

public class Main {
    static int L, N;
    static String[] arr;
    static ArrayList<String> tmp;
    static boolean[] chk;
    static boolean solved = false;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new String[N];
        tmp = new ArrayList<>();
        chk = new boolean[N];

        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);
        bt(0);
        if(!solved) System.out.println("NONE");
    }

    static void bt(int cur){
        if(solved) return;
        if(cur == L){
            for(int i=0; i<L; i++){
                for(int j=0; j<L; j++){
                    char row = tmp.get(i).charAt(j);
                    char col = tmp.get(j).charAt(i);

                    if(row != col) return;
                }
            }

            solved = true;
            for(int i=0; i<L; i++) System.out.println(tmp.get(i));
        }

        for(int i=0; i<N; i++){
            if(chk[i]) continue;
            chk[i] = true;
            tmp.add(arr[i]);
            bt(cur+1);
            chk[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}