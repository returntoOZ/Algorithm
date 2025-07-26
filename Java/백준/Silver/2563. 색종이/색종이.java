import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[100][100];
        Arrays.fill(arr[0], false);

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            x--; y--;

            for (int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    arr[x+j][y+k] = true;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (!arr[i][j]) continue;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
