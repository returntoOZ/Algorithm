#include "iostream"
#include "string"
#include "vector"
#include "algorithm"
using namespace std;

bool comp(string &a, string &b){
  if(a.size() == b.size()){
    return a < b;
  }
  return a.size() < b.size();
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  int N;
  cin >> N;

  string s;
  vector<string> v;
  for(int i=0; i<N; i++){
    cin >> s;

    string sum = "";

    for(int j=0; j<s.size(); j++){
      if(s[j]-'0' >= 0 && 9 >= s[j]-'0'){
        sum += s[j];
      }else{
        if(sum == "") continue;

        while(sum.size() > 1 && sum[0] == '0'){
          sum.erase(0,1);
        }

        v.push_back(sum);
        sum = "";
      }
    }

    if(sum != ""){
      while(sum.size() > 1 && sum[0] == '0'){
        sum.erase(0,1);
      }

      v.push_back(sum);
    }

  }

  sort(v.begin(), v.end(), comp);
  for(auto a : v){
    cout << a << "\n";
  }
}