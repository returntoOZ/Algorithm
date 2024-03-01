#include "iostream"
using namespace std;

int T, M, N, x, y;

int gcd(int a, int b) {
  while (b != 0) {
    int r = a % b;
    a = b;
    b = r;
  }
  return a;
}

int lcm(int a, int b) {
  return a * b / gcd(a, b);
}

int main() {
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> T;
  while (T--) {
    cin >> M >> N >> x >> y;
    int limit = lcm(M, N);
    bool flag = true;

    for(int i=x; i<=limit; i+=M){
      int cury = i%N ? i%N : N;
      if(cury == y) {
        cout << i << '\n';
        flag = false;
        break;
      }
    }
    if(flag) cout << "-1\n";
  }
}