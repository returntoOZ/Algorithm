#include "iostream"
#include "queue"
#include "vector"
using namespace std;

int N, M, X;
vector<pair<int, int>> graph[1001];
int dist[1001];

void reset(){
  for(int i=1; i<=N; i++){
    dist[i] = 999999;
  }
}

void bfs(int start){
  reset();

  queue<pair<int,int>> pq;
  dist[start] = 0;

  for(auto a : graph[start]){
    pq.push(a);
    dist[a.second] = a.first;
  }

  while(!pq.empty()){
    int cur = pq.front().second; pq.pop();

    if(cur == X) {
      continue;
    }

    for(auto node : graph[cur]){
      if(dist[node.second] < dist[cur] + node.first) continue;

      dist[node.second] = dist[cur] + node.first;
      pq.push(node);
    }
  }
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N >> M >> X;

  for(int i=0; i<M; i++){
    int a, b, c;
    cin >> a >> b >> c;
    graph[a].push_back({c, b});
  }

  int ans = -1;
  for(int i=1; i<=N; i++){
    if(i==X) continue;
    int sum = 0;
    bfs(i);
    sum += dist[X];
    bfs(X);
    sum += dist[i];
    ans = max(ans, sum);
  }
  cout << ans;
}