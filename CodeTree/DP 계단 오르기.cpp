//
// Created by 오지환 on 2023/09/05.
//
#include "iostream"
using namespace std;

int dp[1001];
int n;

int main(){
    cin >> n;

    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 1;

    for(int i=5; i<=n; i++){
        dp[i] = (dp[i-2]%10007 + dp[i-3]%10007) % 10007;
    }

    cout << dp[n];
}