#include<iostream>
#include "vector"
#include "queue"
using namespace std;

int N, M, X;
int dist[1001];
vector<pair<int,int>> graph[1001];

void reset(){
  for(int i=1; i<=N; i++){
    dist[i] = 999999;
  }
}

void bfs(int start, int dest){
  reset();
  priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
  dist[start] = 0;
  pq.push({dist[start], start});

  while(!pq.empty()){
    int curNode = pq.top().second, weight = pq.top().first;
    pq.pop();

    if(dist[curNode] < weight) continue;
    if(curNode == dest) break;

    for(auto a : graph[curNode]){
      int compWeight = a.first, nextNode = a.second;
      if(dist[nextNode] <= dist[curNode] + compWeight) continue;
      dist[nextNode] = dist[curNode] + compWeight;
      pq.push({dist[nextNode], nextNode});
    }
  }
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N >> M >> X;

  for(int i=0; i<M; i++){
    int a, b, c;
    cin >> a >> b >> c;
    graph[a].push_back({c,b});
  }

  int ans = -1;
  for(int i=1; i<=N; i++){
    int sum;
    bfs(i, X);
    sum = dist[X];
    bfs(X, i);
    sum += dist[i];
    ans = max(ans, sum);
  }
  cout << ans;
}