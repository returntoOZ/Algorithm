#include "iostream"
using namespace std;

int check[26];

int main(){
  int N;

  cin >> N;

  for(int i=0; i<N; i++){
    string s;
    cin>>s;
    check[s[0]-'a']++;
  }

  bool flag = true;

  for(int i=0; i<26; i++){
    if(check[i]<5) continue;
    cout << (char)('a'+i);
    flag = false;
  }
  if(flag) cout << "PREDAJA";
}