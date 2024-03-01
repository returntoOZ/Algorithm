#include "iostream"
using namespace std;

int N, K, sum[100001];

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N >> K;

  for(int i=1; i<=N; i++){
    int num;
    cin >> num;
    sum[i] = sum[i-1] + num;
  }

  int M = -9999999;
  for(int i=0; i+K<=N; i++){
    int comp = sum[i+K] - sum[i];
    M = max(M, comp);
  }

  cout << M;
}