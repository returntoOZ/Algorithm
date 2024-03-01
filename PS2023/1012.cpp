#include "iostream"
#include "queue"
using namespace std;

int T, N, M, K;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int map[50][50];
bool check[50][50];
queue<pair<int, int>> q;

void reset(int M, int N){
  for(int i=0; i<N; i++){
    for(int j=0; j<M; j++){
      map[i][j] = 0;
      check[i][j] = false;
    }
  }
}

void bfs(){
  while(!q.empty()){
    int cury = q.front().first;
    int curx = q.front().second; q.pop();

    for(int i=0; i<4; i++){
      int nx = curx + dx[i];
      int ny = cury + dy[i];

      if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
      if(map[ny][nx] == 0 || check[ny][nx]) continue;

      check[ny][nx] = true;
      q.push({ny, nx});
    }
  }
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> T;

  while(T--){
    cin >> M >> N >> K;
    reset(M, N);
    for(int i=0; i<K; i++){
      int x, y;
      cin >> x >> y;
      map[y][x] = 1;
    }

    int cnt = 0;
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        if(!check[i][j] && map[i][j] == 1){
          cnt++;
          q.push({i, j});
          check[i][j] = true;
          bfs();
        }
      }
    }

    cout << cnt << '\n';
  }
}