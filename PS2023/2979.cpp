#include "iostream"
using namespace std;

int truck[101];

int main(){
  int a, b, c, sum=0;
  cin >> a >> b >> c;
  b = 2*b;
  c= 3*c;

  for(int i=0; i<3; i++){
    int st, ed;
    cin >> st >> ed;
    for(int j=st; j<ed; j++){
      truck[j]++;
    }
  }

  for(int i=1; i<=100; i++){
    if(truck[i] == 1)
      sum += a;
    else if(truck[i] == 2){
      sum += b;
    }else if(truck[i] == 3){
      sum += c;
    }
  }

  cout << sum;
}