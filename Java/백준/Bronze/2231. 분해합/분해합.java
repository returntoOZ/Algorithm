import java.io.*;
import java.util.*;

public class Main {
    static int recusion(int n){
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for (int i = 1; i <= N; i++) {
            if(recusion(i) + i == N) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(0);
    }
}