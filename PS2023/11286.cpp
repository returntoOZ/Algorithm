#include "iostream"
#include "queue"
using namespace std;

struct comp{
    bool operator()(const int &a, const int &b){
      if(abs(a) == abs(b)){
        return a > b;
      }
      return abs(a) > abs(b);
    }
};

int N, order;
priority_queue<int, vector<int>, comp> pq1;

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N;
  for(int i=0; i<N; i++){
    cin >> order;
    if(order == 0){
      if(pq1.empty()){
        cout << "0\n";
      }else{
        cout << pq1.top() <<'\n';
        pq1.pop();
      }
    }else{
      pq1.push(order);
    }
  }
}