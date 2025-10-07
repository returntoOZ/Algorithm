import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, 1);
        
        for(int l : lost) arr[l]--;
        for(int r : reserve) arr[r]++;
        
        int cnt = 0;
        for(int i=1; i<=n; i++){
            // System.out.println(arr[i]);
            if(arr[i] != 0) cnt++;
        }
        
        for(int i=1; i<n; i++){
            int cmp1 = arr[i], cmp2 = arr[i+1]; 
            
            if((cmp1 == 0 && cmp2 == 2) || (cmp1 == 2 && cmp2 == 0)) {
                cnt++; i++;
            }
        }
        
        return cnt;
    }
}