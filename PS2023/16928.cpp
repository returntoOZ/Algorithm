#include "iostream"
#include "queue"
using namespace std;

int N, M, x, y;
int dist[101], map[101];
queue<int> q;

void bfs(){
  while(!q.empty()){
    int cur = q.front(); q.pop();

    for(int i=1; i<7; i++){
      int nx = cur + i;

      if(nx > 100) continue;
      else if (nx == 100) {
        cout << dist[cur] + 1;
        return;
      }

      if(map[nx]) {
        nx = map[nx];
      }
      if(dist[nx] == 0){
        dist[nx] = dist[cur] + 1;
        q.push(nx);
      }
    }
  }
}

int main(){
  ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

  cin >> N >> M;

  for(int i=0; i<N; i++){
    cin >> x >> y;
    map[x] = y;
  }

  for(int i=0; i<M; i++){
    cin >> x >> y;
    map[x] = y;
  }

  q.push(1);
  bfs();
}