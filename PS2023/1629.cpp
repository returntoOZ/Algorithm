#include "iostream"
#define ll long long
using namespace std;

ll a, b, c;

ll recusion(ll a, ll b, ll c){
  if(b==1) return a%c;

  ll cur = recusion(a, b/2, c);
  if(b%2==0){
    return (cur*cur)%c;
  }else{
    return (((cur*cur)%c)*a)%c;
  }
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> a >> b >> c;

  cout << recusion(a,b,c);
}