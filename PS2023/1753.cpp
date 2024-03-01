#include "iostream"
#include "vector"
#include "queue"
#define INF (1<<31)-1
using namespace std;

int V, E, K;
int dist[20001];
vector<pair<int, int>> graph[20001];

void reset(){
  for(int i=1; i<=V; i++){
    dist[i] = INF;
  }
}

void output(){
  for(int i=1; i<=V; i++){
    if(dist[i] == INF) cout << "INF\n";
    else cout << dist[i] << '\n';
  }
}

void dijkstra(int start){
  reset();
  priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
  dist[start] = 0;
  pq.push({dist[start], start});

  while(!pq.empty()){
    int curNode = pq.top().second;
    int sumWeight = pq.top().first;
    pq.pop();

    if(dist[curNode] < sumWeight) continue;

    for(auto a : graph[curNode]){
      int nextNode = a.first;
      int weight = a.second;

      if(dist[nextNode] <= dist[curNode] + weight) continue;
      dist[nextNode] = dist[curNode] + weight;
      pq.push({dist[nextNode], nextNode});
    }
  }

  output();
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> V >> E;
  cin >> K;
  for(int i=0; i<E; i++){
    int u, v, w;
    cin >> u >> v >> w;
    graph[u].push_back({v,w});
  }

  dijkstra(K);
}