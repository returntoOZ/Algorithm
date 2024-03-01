#include "iostream"
using namespace std;

int N, M, J, cur=1, cnt;

void move(int J){
  int last = cur+M-1;
  if(J > last){
    int gap = J-last;
    cnt += gap;
    cur = J-M+1;
  }
  else if(J < cur){
    int gap = cur - J;
    cnt += gap;
    cur = J;
  }
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N >> M >> J;


  for(int i=0; i<J; i++){
    int num;
    cin >> num;
    move(num);
  }
  cout << cnt;
}