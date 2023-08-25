//
// Created by 오지환 on 2023/08/25.
//
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int map[25][25];
bool check[25][25];
vector<pair<int, int>> starts;
int N, people, cnt; // cnt : 마을 갯수
vector<int> ans; // ans : 각 마을 당 인원 수를 담은 vector

int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

void dfs(int x, int y) {
    check[x][y] = true;
    people++;

    for (int i = 0; i < 4; i++) {
        int curx = x + dx[i];
        int cury = y + dy[i];

        if (curx < 0 || curx >= N || cury < 0 || cury >= N) { // 좌표 밖으로 벗어났을 때
            continue;
        }

        if (map[curx][cury] == 0 || check[curx][cury]) { // 해당 좌표에 벽이 있거나 방문한 적이 있을 때
            continue;
        }

        dfs(curx, cury);
    }

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> map[i][j];
            if (map[i][j] == 1) {
                starts.push_back(make_pair(i, j));
            }
        }
    }

    for (int i = 0; i < starts.size(); i++) {
        if (!check[starts[i].first][starts[i].second]) { // 방문한 적이 없는 곳
            people = 0;
            cnt++;
            dfs(starts[i].first, starts[i].second);
            ans.push_back(people);
        }
    }

    sort(ans.begin(), ans.end());

    cout << cnt << "\n";
    for (auto a : ans) {
        cout << a << "\n";
    }
}
// 피드백 : 상하좌우가 모두 움직이는 상황에서 좌표가 음수가 되는 것도 고려하기!