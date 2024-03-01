#include "iostream"
#include "stack"
using namespace std;

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  int N, ans=0;
  cin >> N;

  for(int i=0; i<N; i++){
    string s;
    cin >> s;
    stack<char> st;
    for(auto a: s){
      if(st.empty()){
        st.push(a);
      }else{
        if(st.top() == a){
          st.pop();
        }else{
          st.push(a);
        }
      }
    }

    if(st.empty()){
      ans++;
    }
  }

  cout << ans;
}