#include "iostream"
#include "stack"
using namespace std;

int check[26];

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  string s;
  stack<char> st;
  char mid = ' ';
  cin >> s;

  for(auto a: s){
    check[a-'A']++;
  }

  bool flag = false;
  string ans;

  for(int i=0; i<26; i++){
    for(int j=0; j<check[i]/2; j++){
      ans += i+'A';
      st.push(i+'A');
    }
    if(check[i] % 2 != 0){ // 홀수
      if(flag){
        cout << "I'm Sorry Hansoo";
        return 0;
      }
      flag = true;
      mid = i+'A';
    }
  }

  if(mid != ' ') {
    ans += mid;
  }
  while(!st.empty()){
    char cur = st.top(); st.pop();
    ans += cur;
  }
  cout << ans;
}