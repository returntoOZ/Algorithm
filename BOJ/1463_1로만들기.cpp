//
// Created by 오지환 on 2023/05/24.
//
#include "iostream"
#include "algorithm"
using namespace std;

int dp[1000001];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N; //입력
    cin >> N;

    dp[1] = 0;

    for(int i=2; i<=N; i++){
        dp[i] = dp[i-1] + 1;
        if(i%2 == 0) dp[i] = min(dp[i], dp[i/2] + 1);
        if(i%3 == 0) dp[i] = min(dp[i], dp[i/3] + 1);
    }
//    dp[2] = dp[3] = 1;
//
//    for(int i = 4; i<=N; i++){
//        if(dp[i-1]){
//            dp[i] = dp[i-1] + 1;
//        }
//
//        if(i%2 == 0 && dp[i/2]){
//            if(dp[i-1] == 0){
//                dp[i] = dp[i/2] + 1;
//            }else{
//                dp[i] = min(dp[i], dp[i/2] + 1);
//            }
//        }
//
//        if(i%3 == 0 && dp[i/3]){
//            if(dp[i-1] == 0 && dp[i/2] == 0){
//                dp[i] = dp[i/3] + 1;
//            }else{
//                dp[i] = min(dp[i], dp[i/3] + 1);
//            }
//        }
//    }

    cout << dp[N];
}