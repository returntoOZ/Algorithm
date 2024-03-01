#include "iostream"
using namespace std;

int check[26];
int main(){
  string s;
  cin >> s;

  for(auto a : s){
    check[a-'a']++;
  }

  for(auto a : check){
    cout << a << ' ';
  }
}