import java.util.*;
import java.io.*;

class Solution {
    public int solution(String numbers) {
        int size = numbers.length();
        
        char[] arr = numbers.toCharArray();
        boolean[] check = new boolean[size];
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        
        dfs(size, arr, check, sb, set);
        
        int maxV = 0;
        for(int s : set) maxV = Math.max(maxV, s);
        
        if(maxV < 2) return 0;
        int answer = 0;
        boolean[] isPrime = eratos(maxV);
        for(int s : set){
            if(isPrime[s]) {
                answer++;
            }   
        }
        return answer;
    }
    
    public static boolean[] eratos(int max){
        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i*i<=max; i++){
            if(!isPrime[i]) continue;
            for(int j=i*i; j<=max; j+= i) isPrime[j] = false;
        }
        
        return isPrime;
    }
    
    public static void dfs(int n, char[] str, boolean[] chk, StringBuilder sb, Set<Integer> s){
        if(sb.length() > 0) s.add(Integer.parseInt(sb.toString()));
        for(int i=0; i<n; i++){
            if(chk[i]) continue;
            chk[i] = true;
            sb.append(str[i]);
            dfs(n, str, chk, sb, s);
            chk[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}