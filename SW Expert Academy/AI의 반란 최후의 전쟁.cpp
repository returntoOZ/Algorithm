//
// Created by 오지환 on 1/8/24.
//
#include "iostream"
using namespace std;

int abil[51][3];
int m[51];

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  int T; cin >> T;

  for(int testcase=1; testcase<=T; testcase++){
    int n; cin >> n;

    for(int y=1; y<=n; y++){
      cin >> abil[y][0] >> abil[y][1] >> abil[y][2];
      m[y] = min(abil[y][0] + abil[y][1], min(abil[y][1] + abil[y][2], abil[y][0]+abil[y][2]));
    }

    int M = 1000000000;
    for(int i=1; i<=n-2; i++){
      for(int j=i+1; j<=n-1; j++){
        for(int k=j+1; k<=n; k++){
          int a = abil[i][1] + abil[i][2] + abil[j][0] + abil[j][2] + abil[k][0] + abil[k][1];
          int b = abil[i][1] + abil[i][2] + abil[j][0] + abil[j][1] + abil[k][0] + abil[k][2];
          int c = abil[i][0] + abil[i][2] + abil[j][1] + abil[j][2] + abil[k][0] + abil[k][1];
          int d = abil[i][0] + abil[i][2] + abil[j][0] + abil[j][1] + abil[k][1] + abil[k][2];
          int e = abil[i][0] + abil[i][1] + abil[j][1] + abil[j][2] + abil[k][0] + abil[k][2];
          int f = abil[i][0] + abil[i][1] + abil[j][0] + abil[j][2] + abil[k][1] + abil[k][2];

          int sum = 0;

          for(int l=1; l<=n; l++){
            if(l == i || l == j || l == k) continue;
            sum += m[l];
          }
          sum += min(a, min(b, min(c, min(d, min(e, f)))));
          if(M > sum) M = sum;
        }
      }
    }
    if(M == 1000000000) M=-1;
    cout << '#' << testcase << ' ' << M << '\n';
  }
}