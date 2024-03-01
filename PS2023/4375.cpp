#include "iostream"
using namespace std;

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
  int n;
  while(cin >> n){
    int comp = 1, cnt =1;
    while(comp%n != 0){
      comp = comp*10 + 1;
      comp %= n;
      cnt++;
    }
    cout << cnt << '\n';
  }
}