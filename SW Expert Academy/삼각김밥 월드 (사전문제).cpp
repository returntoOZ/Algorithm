//
// Created by 오지환 on 1/8/24.
//
#include <iostream>
#include <cmath>
using namespace std;

pair<int,int> dp[10001];

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  int T; cin >> T;
  int repeat = 1;
  int cur = 1;

  while(cur <= 10000){
    for(int i = 1; i<=repeat; i++){
      dp[cur] = {repeat, i};
      cur++;
    }
    repeat++;
  }

  for(int k=1; k<=T; k++){
    int s, e;
    cin >> s >> e;
    int a,b,c,d;

    a = dp[s].first; b=dp[s].second;
    c = dp[e].first; d=dp[e].second;
    cout << '#' << k << ' ';

    if(s == e) cout << "0\n";

    else{
      int gap = abs(a-c);
      if(a>c){
        if(d <= b && b <= d + gap){
          cout << gap << '\n';
        }else if(b < d){
          cout << gap + d-b << '\n';
        }else if(b > d+gap){
          cout << b-d << '\n';
        }
      }else if(a<c){
        if(b <= d && d <= b + gap){
          cout << gap << '\n';
        }else if(d < b){
          cout << gap + b-d << '\n';
        }else if(d > b+gap){
          cout << d-b << '\n';
        }
      }else{ // a == c
        cout << abs(b-d) << '\n';
      }
    }
  }
}