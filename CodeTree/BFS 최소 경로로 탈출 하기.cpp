//
// Created by 오지환 on 2023/08/27.
//
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int map[100][100];
bool check[100][100];
int dist[100][100];
queue<pair<int, int>> Q;
int n, m, ans, flag = 1;

int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

void bfs() {
    while (!Q.empty()) {
        pair<int, int> cur = Q.front(); Q.pop();

        if (cur.first == n - 1 && cur.second == m - 1) {
            flag = 0;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) { // 좌표 밖으로 벗어났을 때
                continue;
            }

            if (map[nx][ny] == 0 || check[nx][ny]) { // 해당 좌표에 뱀이 있거나 방문한 적이 있을 때
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

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> map[i][j];
        }
    }

    Q.push(make_pair(0, 0));
    check[0][0] = true;

    bfs();

    if (flag) {
        cout << -1;
        return 0;
    }
    cout << dist[n - 1][m - 1];
}