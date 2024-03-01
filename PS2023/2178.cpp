#include "iostream"
#include "queue"
using namespace std;

int N, M;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
char map[101][101];
int dist[101][101];

void bfs(){
  queue<pair<int,int>> q;
  q.push({1,1});
  dist[1][1] = 1;

  while(!q.empty()){
    int curx = q.front().first;
    int cury = q.front().second; q.pop();

    if(curx == N && cury == M) return;

    for(int i=0; i<4; i++){
      int nx = curx + dx[i];
      int ny = cury + dy[i];

      if(nx <1 || nx > N || ny < 1 || ny > M) continue;
      if(map[nx][ny] == '0' || dist[nx][ny] > 0) continue;

      dist[nx][ny] = dist[curx][cury] + 1;
      q.push({nx, ny});
    }
  }
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N >> M;
  for(int i=1; i<=N; i++){
    for(int j=1; j<=M; j++){
      cin >> map[i][j];
    }
  }
  bfs();
  cout << dist[N][M];
}