//
// Created by 오지환 on 2023/09/10.
//
#include "iostream"
#define MAX 2147483647
using namespace std;

int dp[201][201], sum[201];
int T, n, a;

int MCM(int n){

    for(int l=1; l<=n-1; l++){ // bottom up 풀이를 위한 for문 설계 (l로 j 변수 control)
        for(int i=1; i<=n-l; i++){ // i : column
            int j = i + l; // j : row (i < j)

            dp[i][j] = MAX; // m[i][j]의 최소 값을 탐색하기 위해 int_Max 값으로 m[i][j] 초기화

            for(int k=i; k<j; k++){
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + sum[j] - sum[i-1]);
            }
        }
    }
}

int main(){
    cin >> T;

    while(T--){
        cin >> n;

        for(int i=1; i<=n; i++){
            cin >> a; // 치킨집 크기 입력 받기
            sum[i] = sum[i-1] + a;
        }

        MCM(n);

        cout << dp[1][n] << "\n";
    }
}
/*
 2
 4
 1 4 3 2
 5
 7 1 3 8 5
 * */