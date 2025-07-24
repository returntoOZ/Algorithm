import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }

        int sum = 0;
        while(pq.size() > 1){
            int num1 = pq.poll();
            int num2 = pq.poll();

            sum += num1 + num2;
            pq.add(num1 + num2);
        }

        System.out.println(sum);
    }
}
