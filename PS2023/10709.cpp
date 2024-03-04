#include "iostream"
#include "queue"
using namespace std;

int H, W;
int dist[100][100];
char map[100][100];
queue<pair<int,int>> q;

void reset(){
  for(int i=0; i<H; i++){
    for(int j=0; j<W; j++){
      dist[i][j] = -1;
    }
  }
}

void output(){
  for(int i=0; i<H; i++){
    for(int j=0; j<W; j++){
      cout << dist[i][j] << ' ';
    }
    cout << '\n';
  }
}

void bfs(){
  while(!q.empty()){
    int curx = q.front().first;
    int cury = q.front().second; q.pop();

    int ny = cury + 1;

    if(ny >= W) continue;
    if(dist[curx][ny] != -1) continue;

    dist[curx][ny] = dist[curx][cury] + 1;
    q.push({curx, ny});
  }

  output();
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> H >> W;

  reset();
  for(int i=0; i<H; i++){
    for(int j=0; j<W; j++){
      cin >> map[i][j];
      if(map[i][j] == 'c') {
        dist[i][j] = 0;
        q.push({i,j});
      }
    }
  }

  bfs();
}