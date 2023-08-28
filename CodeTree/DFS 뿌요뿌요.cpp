//
// Created by 오지환 on 2023/08/28.
//
#include "iostream"
using namespace std;
int map[100][100];
bool check[100][100];
int N, M, h, zone, ans; // zone : 현재 블록 수 , ans : 터지는 블록 수
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

void bfs(int x, int y, int K) {
    check[x][y] = true;
    zone++;

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if (map[nx][ny] != K || check[nx][ny]) continue;

        bfs(nx, ny, K);
    }

}

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> N;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> map[i][j];
            if (h < map[i][j])
                h = map[i][j]; // K 값 뽑아내기
        }
    }

    for (int k = 1; k <= h; k++) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == k && !check[i][j]) { // K 블럭 차례이면서 방문한 적이 없을 때
                    zone = 0; // 초기화
                    bfs(i, j, k);

                    if (zone >= 4)
                        ans++;
                    if (zone > M)
                        M = zone;
                }
            }
        }
    }


    cout << ans << " " << M;
}