#include<iostream>
using namespace std;
typedef unsigned long long ll; // 굳이 long long 안써도 될듯

int T, N;
int dp[10000001];

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> T;

    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= 10000000; i++) {
        dp[i] = (dp[i - 1]% 1000000007 + dp[i - 2]% 1000000007) % 1000000007;
    }

    while (T--) {
        cin >> N;
        cout << dp[N] << "\n";
    }