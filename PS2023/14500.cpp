#include "iostream"
#include "queue"
using namespace std;

int N, M, cnt = -1;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int map[500][500];
bool check[500][500];

void bt(int cur, int x, int y, int sum){
  if(cur == 4){
    cnt = max(cnt, sum);
    return;
  }

  for(int i=0; i<4; i++){
    int nx = x+dx[i];
    int ny = y+dy[i];

    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
    if(check[nx][ny]) continue;

    check[nx][ny] = true;
    bt(cur+1, nx, ny, sum + map[nx][ny]);
    check[nx][ny] = false;
  }
}

void type1(int x, int y){
  if(x+2 >= N || y+1 >=M) return;

  int sum = map[x][y] + map[x+1][y] + map[x+1][y+1] + map[x+2][y];
  cnt = max(cnt, sum);
}

void type2(int x, int y){
  if(x+1 >= N || y-2 < 0) return;

  int sum = map[x][y] + map[x][y-1] + map[x][y-2] + map[x+1][y-1];
  cnt = max(cnt, sum);
}

void type3(int x, int y){
  if(x-2 < 0 || y-1 < 0) return;

  int sum = map[x][y] + map[x-1][y] + map[x-1][y-1] + map[x-2][y];
  cnt = max(cnt, sum);
}

void type4(int x, int y){
  if(x-1 <0 || y+2 >=M) return;

  int sum = map[x][y] + map[x][y+1] + map[x][y+2] + map[x-1][y+1];
  cnt = max(cnt, sum);
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N >> M;

  for(int i=0; i<N; i++){
    for(int j=0; j<M; j++){
      cin >> map[i][j];
    }
  }

  for(int i=0; i<N; i++){
    for(int j=0; j<M; j++){
      check[i][j] = true;
      bt(1, i,j,map[i][j]);
      check[i][j] = false;

      type1(i,j);
      type2(i,j);
      type3(i,j);
      type4(i,j);
    }
  }

  cout << cnt;
}