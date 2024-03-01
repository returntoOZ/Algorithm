#include "iostream"
using namespace std;

int N, cnt, ans;
bool check[1000];

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
  cin >> N;

  for(int i=123; i<=987; i++){
    int first = i/100;
    int second = i/10%10;
    int third = i%10;
    if(first != second && second != third && third != first){
      check[i] = true;
    }
    if(first == 0 || second == 0 || third == 0) {
      check[i] = false;
    }
  } // 기본 세팅

  for(int i=0; i<N; i++){
    int num, s, b;
    cin >> num >> s >> b;

    for(int i=123; i<=987; i++){
      if(!check[i]) continue;

      int st =0, ba =0;
      string cur = to_string(num), comp = to_string(i);

      for(int a=0; a<3; a++){
        for(int b=0; b<3; b++){
          if(a == b && cur[a] == comp[b]) st++;
          if(a != b && cur[a] == comp[b]) ba++;
        }
      }

      if(st != s || ba != b) check[i] = false;
    }
  }

  for(int i=123; i<=987; i++){
    if(check[i]) ans++;
  }
  cout << ans;
}