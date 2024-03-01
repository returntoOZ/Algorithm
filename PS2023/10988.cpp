#include "iostream"
using namespace std;

int main(){
  bool flag = true;
  string s;
  cin >> s;

  for(int i=0; i<s.size()/2; i++){
    if(s[i] != s[s.size()-1-i]){
      cout << 0;
      flag = false;
      break;
    }
  }
  if(flag) cout << 1;
}