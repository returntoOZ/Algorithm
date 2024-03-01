#include "iostream"
using namespace std;

int N, cnt, dp[50001];

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N;

  while(N!=0){
    for(int i=1; i*i<=N; i++){
      dp[i*i] = 1;
      cout << i*i << '\n';
    }
  }
  for(int i=1; i*i<=N; i++){
    dp[i*i] = 1;
    cout << i*i << '\n';
  }


}