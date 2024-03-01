#include "iostream"
#include "queue"
using namespace std;

int N, M;
queue<int> failure;

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
  cin >> N >> M;

  for(int i=0; i<M; i++){
    char input;
    cin >> input;
    if(input == 'I') failure.push(i);
  }

  int cnt=0, gapcnt = 0;

  while(!failure.empty()){
    int st = failure.front(); failure.pop();
    int gap = failure.front() - st;

    if(gap == 2){
      gapcnt++;
      if(gapcnt >= N) cnt++;
    }else{
      gapcnt = 0;
    }
  }
  cout << cnt;
}