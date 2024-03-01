//
// Created by 오지환 on 2023/09/14.
//
#include "iostream"
using namespace std;

int dp[10001][3];
int juc[10001];
int n;

int main(){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin >> n;

    for(int i=1; i<=n; i++){
        cin >> juc[i];
    }

    dp[1][0] = 0;
    dp[1][1] = juc[1];

    for(int i=2; i<=n; i++){
        for(int j=0; j<3; j++){
            if(j == 2){
                dp[i][0] = max(dp[i][0], dp[i-1][2]);
            }else{
                dp[i][j] = max(dp[i][j+1], dp[i-1][j] + juc[i]);
            }
        }
    }

    cout << max(dp[n][0], max(dp[n][1], dp[n][2]));
}