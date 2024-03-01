#include "iostream"
#include "queue"
using namespace std;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int T, w, h;
pair<int,int> s;
char map[1000][1000];
int dist1[1000][1000], dist2[1000][1000];
queue<pair<int, int>> q2;

void bfs1(pair<int,int> start){ // 상근
  queue<pair<int, int>> q;
  q.push(start);
  dist1[start.first][start.second] = 0;

  while(!q.empty()){
    int curx = q.front().first;
    int cury = q.front().second; q.pop();

    for(int i=0; i<4; i++){
      int nx = curx + dx[i];
      int ny = cury + dy[i];

      if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
      if(map[nx][ny] != '.' || dist1[nx][ny] >=0) continue;

      dist1[nx][ny] = dist1[curx][cury] + 1;
      q.push({nx, ny});
    }
  }
}

void bfs2(){ // 불
  while(!q2.empty()){
    int curx = q2.front().first;
    int cury = q2.front().second; q2.pop();

    for(int i=0; i<4; i++){
      int nx = curx + dx[i];
      int ny = cury + dy[i];

      if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
      if(map[nx][ny] == '#' || dist2[nx][ny] >=0) continue;

      dist2[nx][ny] = dist2[curx][cury] + 1;
      q2.push({nx, ny});
    }
  }
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> T;
  while(T--){
    cin >> w >> h;

    for(int i=0; i<h; i++){
      for(int j=0; j<w; j++){
        cin >> map[i][j];
        dist1[i][j] = -1;
        dist2[i][j] = -1;
        if(map[i][j] == '@') s = {i,j};
        else if(map[i][j] == '*') {
          q2.push({i,j});
          dist2[i][j] = 0;
        }
      }
    }

    bfs1(s);
    if(!q2.empty()) bfs2();

    int ans = 9999999;

    for(int i=0; i<w; i++){
      if(dist1[0][i] == -1) continue;
      if(dist2[0][i] == -1 || dist1[0][i] < dist2[0][i]){
        ans = min(ans, dist1[0][i]);
      }
    }

    for(int i=0; i<w; i++){
      if(dist1[h-1][i] == -1) continue;
      if(dist2[h-1][i] == -1 || dist1[h-1][i] < dist2[h-1][i]){
        ans = min(ans, dist1[h-1][i]);
      }
    }

    for(int i=0; i<h; i++){
      if(dist1[i][0] == -1) continue;
      if(dist2[i][0] == -1 || dist1[i][0] < dist2[i][0]){
        ans = min(ans, dist1[i][0]);
      }
    }

    for(int i=0; i<h; i++){
      if(dist1[i][w-1] == -1) continue;
      if(dist2[i][w-1] == -1 || dist1[i][w-1] < dist2[i][w-1]){
        ans = min(ans, dist1[i][w-1]);
      }
    }

    if(ans == 9999999){
      cout << "IMPOSSIBLE\n";
    }else{
      cout << ans+1 <<'\n';
    }
  }
}