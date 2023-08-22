//
// Created by 오지환 on 2023/05/23.
//
#include <iostream>
#include "algorithm"
using namespace std;
int dp[5001];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N;
    cin >> N ; // 입력값

    dp[3] = dp[5] = 1; // 초기값 세팅

    for(int i = 6; i <=  N; i++){
        if(dp[i-3])
            dp[i] = dp[i-3] + 1;

        if(dp[i-5]){ // 핵심 부분 dp[i-3] 값이 있으면 중복의 가능성이 있음 but dp[i-3] == 0 이면 dp[i-5] + 1
            if(dp[i-3] == 0)
                dp[i] = dp[i-5] + 1;
            else
                dp[i] = min(dp[i-5] + 1 , dp[i]);
        }
    }

    cout << (dp[N] == 0 ? -1 : dp[N]);
}