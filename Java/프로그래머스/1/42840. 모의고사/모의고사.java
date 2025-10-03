class Solution {
    public int[] solution(int[] answers) {
        // 1 : 12345 반복
        // 2 : 21232425 반복
        // 3 : 3311224455 반복
        int c1=0,c2=0,c3=0;
        
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0; i<answers.length; i++){
            int cmp = answers[i];
            
            if(cmp == first[i%5]) c1++;
            if(cmp == second[i%8]) c2++;
            if(cmp == third[i%10]) c3++;
        }
        
        int M = -1;
        
        M = Math.max(M, Math.max(c1, Math.max(c2, c3)));
        
        int cnt = 0;
        if(M == c1) cnt++;
        if(M == c2) cnt++;
        if(M == c3) cnt++;
        
        int[] answer = new int[cnt];
        
        int idx = 0;
        if(M == c1) answer[idx++] = 1;
        if(M == c2) answer[idx++] = 2;
        if(M == c3) answer[idx++] = 3;
        return answer;
    }
}