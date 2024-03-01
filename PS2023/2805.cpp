#include "iostream"
#include "queue"
#define ll long long
using namespace std;

int N, M;

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
  cin >> N >> M;
  priority_queue<ll> pq;
  for(int i=0; i<N; i++){
    ll h;
    cin >> h;
    pq.push(h);
  }

  ll sum =0;
  ll cnt = 0;

  while(!pq.empty()){
    ll cur = pq.top(); pq.pop();
    ll gap;
    if(pq.empty()) gap = cur;
    else gap = cur-pq.top();
    cnt++;

    if(sum + gap * cnt > M){
      ll target = M-sum;

      if(target % cnt == 0){
        cout << cur - target/cnt;
        break;
      }
      else{
        cout << cur - target/cnt - 1;
        break;
      }
    }
    else if(sum + gap * cnt == M){
      if(pq.empty()) cout << 0;
      else cout << pq.top();
      break;
    }else{
      sum += gap * cnt;
    }
  }
}