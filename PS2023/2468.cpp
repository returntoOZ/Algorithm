#include "iostream"
#include "queue"
using namespace std;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int N, cnt;
int map[100][100];
bool check[100][100];
queue<pair<int,int>> q;

void reset(){
  for(int i=0; i<N; i++){
    for(int j=0; j<N; j++){
      check[i][j] = false;
    }
  }
}

void bfs(int h){
  while(!q.empty()){
    int curx = q.front().first;
    int cury = q.front().second; q.pop();

    for(int i=0; i<4; i++){
      int nx = curx + dx[i];
      int ny = cury + dy[i];

      if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
      if(check[nx][ny] || map[nx][ny] <= h) continue;

      check[nx][ny] =true;
      q.push({nx, ny});
    }
  }
}

int main(){
  cin >> N;

  for(int i=0; i<N; i++){
    for(int j=0; j<N; j++){
      cin >> map[i][j];
    }
  }

  int ans = 1;
  for(int h=1; h<=100; h++){
    cnt = 0;
    reset();
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        if(!check[i][j] && map[i][j] > h){
          q.push({i,j});
          check[i][j] = true;
          cnt++;
          bfs(h);
        }
      }
    }
    ans = max(ans, cnt);
  }

  cout << ans;
}