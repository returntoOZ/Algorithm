#include "iostream"
#include "vector"
using namespace std;

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  int N;
  cin >> N;
  string pattern, front, rear;
  bool flag = true;
  vector<string> v;

  cin >> pattern;

  for(int i=0; i<pattern.size(); i++){
    if(pattern[i] == '*'){
      flag = false;
      continue;
    }
    if(flag){
      front += pattern[i];
    }else{
      rear += pattern[i];
    }
  }

  for(int i=0; i<N;i++){
    string s;
    cin >> s;
    v.push_back(s);
  }

  for(auto a:v){
    bool flag = true;

    if(front.size() + rear.size() > a.size()){
      cout << "NE\n";
      continue;
    }

    for(int i=0; i<front.size(); i++){
      if(a[i] != front[i]){
        cout << "NE\n";
        flag = false;
        break;
      }
    }

    if(!flag) continue;

    int st = a.size()-rear.size();
    for(int i=0; i<rear.size(); i++){
      if(a[st+i] != rear[i]){
        cout << "NE\n";
        flag = false;
        break;
      }
    }

    if(flag) cout << "DA\n";
  }
}