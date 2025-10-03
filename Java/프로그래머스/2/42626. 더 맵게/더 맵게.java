import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.offer(s);
        }
        
        while(true){
            if(pq.size() == 1) break;
            int first = pq.poll();
            int second = pq.poll();
            
            if(first >= K) return answer;
            
            pq.offer(first + 2*second);
            answer++;
        }
        
        if(pq.poll() < K) return -1;
        return answer;
    }
}