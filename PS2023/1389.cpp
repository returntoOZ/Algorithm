#include "iostream"
using namespace std;

int N, M;
int dp[101][101];

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N >> M;
  for(int i=1; i<=N; i++){
    for(int j=1; j<=N; j++){
      dp[i][j] = 100000;
    }
  }

  for(int i=0; i<M; i++){
    int a,b;
    cin >> a >> b;
    dp[a][b] = 1;
    dp[b][a] = 1;
  }

  for(int k=1; k<=N; k++){
    for(int i=1; i<=N; i++){
      //if(i==j) continue;
      for(int j=1; j<=N; j++){
        if(i==j || i==k || j==k) continue;
        dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
      }
    }
  }

  int m = 99999999;
  int ans = 1;

  for(int i=1; i<=N; i++){
    int sum = 0;
    for(int j=1; j<=N; j++){
      if(i==j) continue;
      sum += dp[i][j];
    }
    if(m>sum){
      m = sum;
      ans = i;
    }
  }

//  for(int i=1; i<=N; i++){
//    for(int j=1; j<=N; j++){
//      cout << dp[i][j] << ' ';
//    }
//    cout << '\n';
//  }
  cout << ans;
}