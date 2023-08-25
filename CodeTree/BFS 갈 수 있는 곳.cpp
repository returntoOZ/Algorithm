//
// Created by 오지환 on 2023/08/26.
//
#include<iostream>
#include<queue>
using namespace std;

int map[100][100];
bool check[100][100];
queue<pair<int, int>> Q;
int N, K, r, c, aws;

int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

void bfs() {
    while (!Q.empty()) {
        pair<int, int> cur = Q.front(); Q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) { // 좌표 밖으로 벗어났을 때
                continue;
            }

            if (map[nx][ny] == 1 || check[nx][ny]) { // 해당 좌표에 뱀이 있거나 방문한 적이 있을 때
                continue;
            }

            Q.push(make_pair(nx, ny));
            check[nx][ny] = true;
            aws++;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> K;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> map[i][j];
        }
    }

    for (int i = 0; i < K; i++) {
        cin >> r >> c;
        if (!check[r-1][c-1]) {
            Q.push(make_pair(r-1, c-1));
            check[r-1][c-1] = true;
            aws++;
            bfs();
        }
    }

    cout << aws;
}