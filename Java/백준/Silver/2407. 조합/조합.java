import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        BigInteger cur = BigInteger.ONE;

        for(int i=1; i<=m; i++){
            cur = cur.multiply(BigInteger.valueOf(n--));
            cur = cur.divide(BigInteger.valueOf(i));
        }
        System.out.print(cur);
    }
}
