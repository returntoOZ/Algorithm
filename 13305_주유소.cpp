#include "iostream"
#include "algorithm"
#define MAX 100001
#define ll long long
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N;
    cin >> N;

    ll dist[MAX], price[MAX]; // dist : 거리 , price : 가격

    for(int i=0; i<N-1; i++){
        cin >> dist[i];
    }
    for(int i=0; i<N; i++){
        cin >> price[i];
    }

    ll sum = price[0] * dist[0];
    int min = price[0];

    for(int i=1; i<N-1; i++){
        if(min > price[i])
            min = price[i];
        sum += min * dist[i];
    }

    cout << sum;
}
