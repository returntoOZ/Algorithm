#include "iostream"
#include "unordered_map"
#include "stack"
using namespace std;

int N, C, arr[1000];
unordered_map<int,int> dict;
unordered_map<int, bool> check;

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N >> C;
  for(int i=0; i < N; i++){
    cin >> arr[i];
    check[arr[i]] = false;
    if(dict[arr[i]] > 0){
      dict[arr[i]]++;
    }else{
      dict[arr[i]] = 1;
    }
  }

}