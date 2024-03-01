#include "iostream"
#include "vector"
#include "queue"
using namespace std;

int N, map[101][101];
bool check[101];
vector<int> graph[101];

void bfs(int st){
  queue<int> q;
  check[st] = true;
  q.push(st);

  while(!q.empty()){
    int cur = q.front(); q.pop();

    for(auto a: graph[cur]){
      map[st][a] = 1;
      if(check[a]) continue;
      check[a] = true;
      q.push(a);
    }
  }

  for(int j=1; j<=N; j++){
    check[j] = false;
  }
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N;
  for(int i=1; i<=N; i++){
    for(int j=1; j<=N; j++){
      cin >> map[i][j];
      if(map[i][j] == 1){
        graph[i].push_back(j);
      }
    }
  }

  for(int i=1; i<=N; i++){
    bfs(i);
  }

  for(int i=1; i<=N; i++){
    for(int j=1; j<=N; j++){
      cout << map[i][j] <<' ';
    }
    cout << '\n';
  }
}