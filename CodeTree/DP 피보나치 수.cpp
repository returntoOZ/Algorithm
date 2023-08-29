//
// Created by 오지환 on 2023/08/29.
//
#include "iostream"
using namespace std;

int N;
int dp[46];


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> N;

    dp[1] = 1;
    dp[2] = 1;

    for (int i = 3; i <= N; i++)
        dp[i] = dp[i - 1] + dp[i - 2];

    cout << dp[N];
}