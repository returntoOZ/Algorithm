import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minPQ = new PriorityQueue<>(); // 큰 값들
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(br.readLine());

            if(minPQ.isEmpty() || maxPQ.isEmpty()){ // 1,2번일 때
                minPQ.add(num);
            }
            else{
                if(minPQ.peek() > num){
                    maxPQ.add(num);
                }else{
                    minPQ.add(num);
                }
            }

            if(i%2 == 1){ // 홀수일 때
                if(minPQ.size() < maxPQ.size()){
                    sb.append(maxPQ.peek()).append("\n");
                }else{
                    sb.append(minPQ.peek()).append("\n");
                }
            }else{
                if(minPQ.size() > maxPQ.size()){
                    maxPQ.add(minPQ.poll());
                }else if(maxPQ.size() > minPQ.size()){
                    minPQ.add(maxPQ.poll());
                }

                sb.append(maxPQ.peek()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
