#include "iostream"
using namespace std;

int N, M, ans[9];
bool check[9];
void bt(int cur){
  if(cur == M){
    for(int i=0; i<M; i++){
      cout << ans[i] << ' ';
    }
    cout << '\n';
    return;
  }

  for(int i=1; i<=N; i++){
    if(!check[i]) {
      ans[cur] = i;
      check[i] = true;
      bt(cur+1);
      check[i] = false;
    }
  }
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
  cin >> N >> M;
  bt(0);
}