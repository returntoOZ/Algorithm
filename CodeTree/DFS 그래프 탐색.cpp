//
// Created by 오지환 on 2023/08/25.
//
#include<iostream>
#include<vector>
using namespace std;

vector<int> graph[1001];
bool check[1001];
int N, M, ans;

void dfs(int node) {
    check[node] = true;

    for (int i = 0; i < graph[node].size(); i++) {
        if (!check[graph[node][i]]) {
            dfs(graph[node][i]);
            ans++;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    int x, y;

    for (int i = 0; i < M; i++) {
        cin >> x >> y;
        graph[x].push_back(y);
        graph[y].push_back(x);
    }

    dfs(1);
    cout << ans;
}