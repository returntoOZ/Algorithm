#include "iostream"
#include "queue"
using namespace std;

int T, N, M;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int dist[101][101];
char map[101][101];

int bfs(){
  priority_queue<pair<int, pair<int,int>>, vector<pair<int, pair<int,int>>>, greater<pair<int, pair<int,int>>>> pq;
  pq.push({0,{0,0}});

  while(!pq.empty()){
    int curx = pq.top().second.first;
    int cury = pq.top().second.second;
    int broke = pq.top().first;
    pq.pop();

    if(curx == M-1 && cury == N-1) return broke;

    for(int i=0; i<4; i++){
      int nx = curx + dx[i];
      int ny = cury + dy[i];

      if(nx <0 || nx >= M || ny < 0 || ny >= N) continue;

      if(map[nx][ny] == '0'){
        if(dist[nx][ny] <= broke) continue;
        dist[nx][ny] = broke;
        pq.push({broke, {nx, ny}});
      }

      if(map[nx][ny] == '1'){
        if(dist[nx][ny] <= broke + 1) continue;
        dist[nx][ny] = broke + 1;
        pq.push({broke + 1, {nx, ny}});
      }
    }
  }
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> T;
  while(T--){
    cin >> N >> M;
    for(int i=0; i<M; i++){
      for(int j=0; j<N; j++){
        cin >> map[i][j];
        dist[i][j] = 0x7f;
      }
    }
    cout << bfs() << "\n";
  }
}