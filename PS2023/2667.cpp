#include "iostream"
#include "queue"
#include "vector"
#include "algorithm"
using namespace std;

int N, local;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
char map[25][25];
bool check[25][25];
queue<pair<int,int>> q;
vector<int> ans;

void bfs(){
  while(!q.empty()){
    int curx = q.front().first;
    int cury = q.front().second;
    q.pop();

    for(int i=0; i<4; i++){
      int nx = curx + dx[i];
      int ny = cury + dy[i];

      if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
      if(check[nx][ny] || map[nx][ny] == '0') continue;

      check[nx][ny] = true;
      q.push({nx, ny});
      local++;
    }
  }

  ans.push_back(local);
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N;

  vector<pair<int, int>> v;
  for(int i=0; i<N; i++){
    for(int j=0; j<N; j++){
      cin >> map[i][j];
      if(map[i][j] == '1') v.push_back({i,j});
    }
  }

  int total = 0;

  for(auto b : v){
    if(!check[b.first][b.second]){
      q.push({b.first, b.second});
      check[b.first][b.second] = true;
      local = 1; total++;
      bfs();
    }
  }

  sort(ans.begin(), ans.end());

  cout << total << '\n';
  for(auto a : ans)
    cout << a <<'\n';
}