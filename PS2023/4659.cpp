#include "iostream"
#include "string"
using namespace std;

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  string s;
  while(1){
    cin >> s;
    if(s == "end") break;

    bool flag1 = false, flag2 = true, flag3= true;
    int mo = 0, ja = 0;

    for(int i=0; i<s.size(); i++){
      if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u'){
        flag1 = true;
        mo++; ja = 0;
      }else{
        ja++; mo = 0;
      }

      if(mo >= 3 || ja >= 3){
        flag2 = false;
      }

      if(i>=1 && s[i-1] == s[i]){
        if(s[i] == 'e' || s[i] == 'o')
          continue;
        else{
          flag3 = false;
        }
      }
    }

    if(flag1 && flag2 && flag3)
      cout << '<' << s << '>' << " is acceptable.\n";
    else
      cout << '<' << s << '>' << " is not acceptable.\n";
  }
}