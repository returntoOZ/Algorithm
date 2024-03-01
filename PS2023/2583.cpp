#include "iostream"
#include "queue"
#include "vector"
#include "algorithm"
using namespace std;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int M, N, K, cnt;
int map[100][100];
bool check[100][100];
queue<pair<int,int>> q;

int bfs(){
  int area = 1;
  while(!q.empty()){
    int curx = q.front().first;
    int cury = q.front().second; q.pop();

    for(int i=0; i<4; i++){
      int nx = curx + dx[i];
      int ny = cury + dy[i];

      if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
      if(check[nx][ny] || map[nx][ny] == 1) continue;

      check[nx][ny] = true;
      area++;
      q.push({nx, ny});
    }
  }
  return area;
}

int main(){
  cin >> M >> N >> K;

  for(int i=0; i<K; i++){
    int x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;

    for(int j=y1; j<y2; j++){
      for(int k=x1; k<x2; k++){
        map[j][k] = 1;
      }
    }
  }

  vector<int> v;

  for(int i=0; i<M; i++){
    for(int j=0; j<N; j++){
      if(!check[i][j] && map[i][j] == 0){
        q.push({i, j});
        check[i][j] = 1;
        cnt++;
        v.push_back(bfs());
      }
    }
  }

  cout << cnt << '\n';
  sort(v.begin(), v.end());
  for(auto a: v){
    cout << a << ' ';
  }
}