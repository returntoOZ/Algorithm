#include "iostream"
#include "vector"
#include "algorithm"
using namespace std;

vector<int> inven;

int main(){
  ios::sync_with_stdio(false);cin.tie(NULL); cout.tie(NULL);

  int N, M, ans =0;
  cin >> N >> M;

  for(int i=0; i<N; i++){
    int num;
    cin >> num;
    inven.push_back(num);
  }
  sort(inven.begin(), inven.end());

  int st = 0, ed = N-1;

  while(st < ed){
    int sum = inven[st] + inven[ed];
    if(sum == M){
      st++; ed--;
      ans++;
    }else if(sum <M){
      st++;
    }else{
      ed--;
    }
  }

  cout << ans;
}