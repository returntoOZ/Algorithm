#include "iostream"
using namespace std;

int main(){
  string s;
  getline(cin, s);

  for(int i=0; i<s.size(); i++){
    if(s[i]-'a'>=0 && s[i]-'a'<26){ // 소문자 일 때
      if(s[i] + 13 > 'z') s[i] = (char)((s[i] - 13));
      else s[i] = (char)((s[i] + 13));
    }
    else if(s[i]-'A'>=0 && s[i]-'A'<26){ // 대문자 일 때
      if(s[i] + 13 > 'Z') s[i] = (char)((s[i] - 13));
      else s[i] = (char)((s[i] + 13));
    }
  }

  cout<<s;
}