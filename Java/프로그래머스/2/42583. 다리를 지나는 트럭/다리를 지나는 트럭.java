import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<bridge_length; i++) q.offer(0);
        
        int sum = 0, time = 0, idx = 0, size = truck_weights.length;
        while(!q.isEmpty()){
            int cur = q.poll();
            sum -= cur;
            
            if(idx == size){
                time++;
                continue;
            }
            if(idx < size && sum + truck_weights[idx] <= weight) {
                int t = truck_weights[idx];
                sum += t;
                q.offer(t);
                idx++;
            }
            else q.offer(0);
            time++;
        }

        return time;
    }
}