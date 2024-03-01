#include "iostream"
using namespace std;

int N, cnt = 0;
bool vertical[15], diagonal1[30], diagonal2[30];

void bt(int cur){
  if(cur == N+1){
    cnt++;
    return;
  }

  for(int i=1; i<=N; i++){
    if(!vertical[i] && !diagonal1[cur+i] && !diagonal2[N+i-cur]){
      vertical[i] = 1;
      diagonal1[cur+i] = 1;
      diagonal2[N+i-cur] = 1;
      bt(cur+1);
      vertical[i] = 0;
      diagonal1[cur+i] = 0;
      diagonal2[N+i-cur] = 0;
    }
  }
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
  cin >> N;
  bt(1);
  cout << cnt;
}