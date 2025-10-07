import java.util.*;

class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        int size = numbers.length;
        
        dfs(0, 0, numbers, target);
        
        return cnt;
    }
    
    static void dfs(int n, int sum, int[] arr, int tar){
        if(n == arr.length){
            if(sum == tar) cnt++;
            return;
        }
        
        dfs(n+1, sum-arr[n], arr, tar);
        dfs(n+1, sum+arr[n], arr, tar);
    }
}