#include "iostream"
#include "algorithm"
using namespace std;

int ATM[1001];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N, sum1 = 0, sum2 = 0; // 사람들의 수
    cin >> N;

    for(int i=0;i<N;i++){
        cin >> ATM[i];
    }

    sort(ATM, ATM+N);

    for(int i=0; i<N; i++){
        sum1 += ATM[i];
        sum2 += sum1;
    }

    cout << sum2;
}
