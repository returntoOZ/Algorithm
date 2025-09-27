class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int cnt1=0, cnt2=0;
        for(char a : s.toCharArray()){
            if(a == 'p' || a == 'P') cnt1++;
            else if(a == 'y' || a == 'Y') cnt2++;
        }

        return cnt1 == cnt2;
    }
}