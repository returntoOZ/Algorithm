//
// Created by 오지환 on 2023/08/25.
//
#include<iostream>
using namespace std;

int map[100][100];
bool check[100][100];
int N, M, ans;

int dx[2] = { 1,0 };
int dy[2] = { 0,1 };

void dfs(int x, int y) {
    if (x == N - 1 && y == M - 1){ // 우측 하단에 도착했을 때
        ans = 1;
        return;
    }

    check[x][y] = true;

    for (int i = 0; i < 2; i++) {
        int curx = x + dx[i];
        int cury = y + dy[i];

        if (curx >= N || cury >= M) { // 좌표 밖으로 벗어났을 때
            continue;
        }

        if (map[curx][cury] == 0 || check[curx][cury]) { // 해당 좌표에 뱀이 있거나 방문한 적이 있을 때
            continue;
        }

        dfs(curx, cury);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> map[i][j];
        }
    }

    dfs(0, 0);
    cout << ans;
}