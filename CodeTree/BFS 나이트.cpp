//
// Created by 오지환 on 2023/08/27.
//
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

bool check[100][100];
int dist[100][100];
queue<pair<int, int>> Q;
int n, r1, c1, r2, c2, flag = 1;

int dx[8] = { -1, -2, -2, -1, 1, 2, 2, 1 };
int dy[8] = { -2, -1, 1, 2, -2, -1, 1, 2 };

void bfs() {
    while (!Q.empty()) {
        pair<int, int> cur = Q.front(); Q.pop();

        if (cur.first == r2 - 1 && cur.second == c2 - 1) {
            flag = 0;
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) { // 좌표 밖으로 벗어났을 때
                continue;
            }

            if (check[nx][ny]) { // 해당 좌표에 방문한 적이 있을 때
                continue;
            }

            Q.push(make_pair(nx, ny));
            check[nx][ny] = true;
            dist[nx][ny] = dist[cur.first][cur.second] + 1;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> r1 >> c1 >> r2 >> c2;

    Q.push(make_pair(r1-1, c1-1));
    check[r1-1][c1-1] = true;

    bfs();

    if (flag) {
        cout << -1;
        return 0;
    }
    cout << dist[r2 - 1][c2 - 1];
}