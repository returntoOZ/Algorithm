//
// Created by 오지환 on 2023/08/23.
//
#include <iostream>
using namespace std;
int arr[200][200];
int n, m, ans;
int M = 0;

void st(int x, int y) { // 1x3 , 3x1 일자형 블록
    int sum = 0;

    for (int i = 0; i < 3; i++) {
        if (x + i >= n) {
            continue;
        }

        sum += arr[x + i][y];
    }

    if (M < sum)
        M = sum;

    sum = 0;

    for (int j = 0; j < 3; j++) {
        if (y + j >= m) {
            break;
        }

        sum += arr[x][y + j];
    }

    if (M < sum)
        M = sum;
}

void hing(int x, int y) { // 기억자 블록 , 2x2를 구하고 해당 값중 3개만 더하면 될듯
    int ar[2][2];

    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            if (x + i >= n || y + j >= m) {
                return;
            }

            ar[i][j] = arr[x + i][y + j];
        }
    }

    int a = ar[0][0] + ar[0][1] + ar[1][0];
    int b = ar[0][0] + ar[1][0] + ar[1][1];
    int c = ar[0][0] + ar[0][1] + ar[1][1];
    int d = ar[1][0] + ar[0][1] + ar[1][1];

    if (M < a)
        M = a;
    if (M < b)
        M = b;
    if (M < c)
        M = c;
    if (M < d)
        M = d;
}

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            st(i, j);
            hing(i, j);
        }
    }

    cout << M;
    return 0;
}