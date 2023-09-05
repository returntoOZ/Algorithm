//
// Created by 오지환 on 2023/09/05.
//
//
// Created by 오지환 on 2023/09/05.
//
#include "iostream"
using namespace std;

int dp[1001];
int n;

int main(){
    cin >> n;

    dp[1] = 1;
    dp[2] = 2;

    for(int i=3; i<=n; i++){
        dp[i] = (dp[i-1]%10007 + dp[i-2]%10007) % 10007;
    }

    cout << dp[n];
}