#include "iostream"
#include "unordered_map"
#include "vector"
#include "algorithm"
using namespace std;

int N, C, arr[1000];
unordered_map<int,int> dict;
unordered_map<int, int> order;

bool comp(pair<int,int> &a, pair<int,int> &b){
  if(a.second == b.second){
    return order[a.first] < order[b.first];
  }
  return a.second > b.second;
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N >> C;
  for(int i=0; i < N; i++){
    cin >> arr[i];

    if(order[arr[i]] == 0){
      order[arr[i]] = i+1;
    }

    if(dict[arr[i]] > 0){
      dict[arr[i]]++;
    }else{
      dict[arr[i]] = 1;
    }
  }

  vector<pair<int,int>> v(dict.begin(), dict.end());
  sort(v.begin(), v.end(), comp);

  for(auto a: v){
    for(int i=0 ;i<a.second; i++){
      cout << a.first << ' ';
    }
  }
}