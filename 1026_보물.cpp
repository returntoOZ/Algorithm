#include "iostream"
#include "algorithm"
using namespace std;

int A[50];
int B[50];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N;
    cin >> N;

    for(int i=0; i<N; i++){
        cin >> A[i];
    }

    for(int i=0; i<N; i++){
        cin >> B[i];
    }

    sort(A, A+N);
    sort(B, B+N);

    int sum = 0;
    for(int i=0; i<N; i++){
        sum += A[i] * B[N-i-1];
    }

    cout << sum;
}
