#include "iostream"
#include "vector"
#include "algorithm"
using namespace std;

vector<int> computer[10001];
bool check[10001];

bool compare (const pair<int, int>&a, const pair<int, int>&b){
  if(a.first == b.first) return a.second < b.second;
  return a.first > b.first;
}

int bfs(int cur, int cnt){
  for(auto a : computer[cur]){
    if(check[a]) continue;
    check[a] = true;
    cnt = bfs(a, cnt + 1);
  }
  return cnt;
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  int N, M;
  cin >> N >> M;

  for(int i=0; i<M; i++){
    int a, b;
    cin >> a >> b;
    computer[b].push_back(a);
  }

  vector<pair<int, int>> ans;
  for(int i=1; i<=N; i++){
    check[i] = true;
    int cnt = bfs(i, 0);
    for(int i=1; i<=N; i++){
      check[i] = false;
    }
    ans.push_back({cnt,i});
  }

  sort(ans.begin(), ans.end(), compare);

  int size = ans.size();
  int cur = ans[0].first;
  cout << ans[0].second;
  for(int i=1; i<size; i++){
    if(cur > ans[i].first) continue;
    cout << ' ' << ans[i].second;
  }
}