#include "iostream"
#include "algorithm"
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    bool flag = false;

    string N;
    cin >> N;

    int sum = 0;
    for(int i=0; i<N.size(); i++){
        sum += N[i]-'0';
        if(N[i]-'0' == 0)
            flag = true;
    }

    sort(N.begin(), N.end(), greater<>());

    if(flag && sum % 3 == 0){
        cout << N;
    }else{
        cout << -1;
    }
}