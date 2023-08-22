#include "iostream"
#include "algorithm"
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N, rope[100001];;
    cin >> N;

    for(int i=0; i<N; i++){
        cin >> rope[i];
    }

    sort(rope, rope + N);

    int M = rope[N-1];

    for(int i=1; i<N; i++){
        if(M < rope[N-i-1] * (i+1)){
            M = rope[N-i-1] * (i+1);
        }
    }

    cout << M;
}