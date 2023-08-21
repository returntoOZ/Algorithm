#include <iostream>
#include <algorithm>
#define INF 10000
using namespace std;

int arr[101][101]; // 입력 배열

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N;
    cin >> N;

    for(int i=1; i<=N; i++){
        for(int j=1; j<= N; j++){
            cin >> arr[i][j];
            if(arr[i][j] == 0) arr[i][j] = INF;
        }
    }

    for(int k=1; k<=N; k++){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j]);
            }
        }
    }

    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            if(arr[i][j] == INF)
                cout << 0 << " ";

            else
                cout << 1 << " ";
        }
        cout <<"\n";
    }
}