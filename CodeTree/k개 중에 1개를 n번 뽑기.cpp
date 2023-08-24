//
// Created by 오지환 on 2023/08/24.
//
#include <iostream>
#include <vector>
using namespace std;
vector<int> arr;
int N, K;

void bt(int cur) {
    if (cur == 0) {
        for (auto a : arr) {
            cout << a << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = 1; i <= K; i++) {
        arr.push_back(i);
        bt(cur - 1);
        arr.pop_back();
    }
}

int main() {
    cin >> K >> N;

    bt(N);

    return 0;
}