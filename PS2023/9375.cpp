#include "iostream"
#include "vector"
#include "unordered_map"
using namespace std;

int T, n;

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> T;
  while(T--){
    cin >> n;
    unordered_map<string, int> dict;
    vector<string> v;

    for(int i=0; i<n; i++){
      string name, type;
      cin >> name >> type;

      if(dict[type]>=1){
        dict[type]++;
      }else{
        v.push_back(type);
        dict[type] = 1;
      }
    }

    int sum =1;
    for(auto a : v){
      sum *= (dict[a]+1);
    }

    cout << sum-1 << '\n';
  }
}