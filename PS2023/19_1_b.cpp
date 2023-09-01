//
// Created by 오지환 on 2023/08/31.
//
#include "iostream"
#include "algorithm"
using namespace std;

int arr[1000001];

int binary_search(int st, int end, int X) {
    if (end < st)
        return -1;
    else {
        int mid = (st + end) / 2;

        if (arr[mid] > X)
            binary_search(st, mid, X);
        else if (arr[mid] < X)
            binary_search(mid + 1, end, X);
        else
            return mid;
    }
}

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int T, N, M, X;

    cin >> T;

    while (T--) {
        cin >> N >> M;

        for (int i = 1; i <= N; i++) {
            cin >> arr[i]; // 머리카락 입력 받기
        }
        sort(arr+1, arr + N+1); // 머리카락 오름차순 정렬

        for (int i = 0; i < M; i++) {
            cin >> X;
            cout << binary_search(1, N, X) << "\n";
        }
    }
}
/*
1
10 3
3 13 17 43 54 111 123 132 231 421
43
231
123
*/