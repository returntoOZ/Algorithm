//
// Created by 오지환 on 2023/08/23.
//
#include <iostream>
using namespace std;
int arr[100][100];
int n, m, cont, ans;

void row(int k) { // 행 기준

    cont = 1; // cont : 현재 연속된 수열 갯수

    int cur = arr[k][0]; // 비교 대상

    for (int i = 1; i < n; i++) {

        if (arr[k][i] == cur) {
            cont++;
        }
        else {
            cont = 1;
        }

        cur = arr[k][i];

        if (m <= cont) {
            ans++;
            return;
        }
    }
}

void col(int k) { // 열 기준

    cont = 1; // cont : 현재 수열 갯수

    int cur = arr[0][k]; // 비교 대상

    for (int j = 1; j < n; j++) {
        if (arr[j][k] == cur) {
            cont++;

        }
        else {
            cont = 1;

        }

        cur = arr[j][k];

        if (m <= cont) {
            ans++;
            return;
        }
    }
}

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }
    if(n==1){
        cout << 2;
    }
    else{
        for (int i = 0; i < n; i++) {
            row(i);
            col(i);
        }

        cout << ans;
    }
    return 0;
}
// 피드백
// n = 1 일때, 예외 처리 생각하기! => 한번에 해결할 수 있는 코드로 짜보기