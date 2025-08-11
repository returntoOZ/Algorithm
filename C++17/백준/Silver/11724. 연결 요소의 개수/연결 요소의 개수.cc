#include<iostream>
#include<vector>
#include<queue>
#define MAX 1001
using namespace std;

int N, M, u, v;
vector<int> adjList[MAX];
bool check[MAX];
int cnt=0;

void BFS(int start) {
	if (check[start]) return;
	
	queue<int> Q;
	Q.push(start);
	check[start] = true;
	cnt++;
	
	while (!Q.empty()) {
		int cur = Q.front(); Q.pop();
		
		for (auto a : adjList[cur]) {

			if (check[a]) continue;

			Q.push(a);
			check[a] = true;
		}

	}
}

int main() {
	cin >> N >> M;
	
	while (M--) {
		cin >> u >> v;

		adjList[u].push_back(v);
		adjList[v].push_back(u);
	}

	for (int i = 1; i <= N; i++) {
		BFS(i);
	}
	
	cout << cnt;
}