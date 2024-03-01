#include "iostream"
using namespace std;

int N, M;
bool check[10];

int main(){
  ios::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

  cin >> N >> M;

  for(int i=0; i<M; i++){
    int num;
    cin >> num;
    check[num] = true;
  }

  if(N == 100) {
    cout << 0;
    return 0;
  }

  int m = abs(N-100);

  for(int i=0; i<=1000000; i++){
    string ans = to_string(i);
    bool flag = true;

    for(auto a : ans){
      if(check[a-'0']){
        flag = false;
        break;
      }
    }

    int comp;
    if(flag) {
      comp = abs(i-N) + ans.size();
      m = min(m, comp);
    }
  }

  cout << m;
}