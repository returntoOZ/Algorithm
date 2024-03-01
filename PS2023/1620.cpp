#include "iostream"
#include "string"
#include "unordered_map"
using namespace std;

int N, M;
unordered_map<int, string> dict1;
unordered_map<string, int> dict2;

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N >> M;

  for(int i=1; i<=N; i++){
    string s;
    cin >> s;
    dict1[i] = s;
    dict2[s] = i;
  }

  for(int i=0; i<M; i++){
    string s;
    cin >> s;
    if(s[0]-'0'<0 || s[0]-'0'>9){ // 영어
      cout << dict2[s] << '\n';
    }else{
      int num = stoi(s);
      cout << dict1[num] << '\n';
    }
  }
}