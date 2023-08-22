//
// Created by 오지환 on 2023/08/22.
//
#include <iostream>
using namespace std;
int arr[20][20];
int N, sum;

int coin (int x, int y){
    sum = 0;

    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            if(x+i >= N || y+i >= N){ // 격자점 바깥으로 나갔을 때
                return -1;
            }

            if(arr[x+i][y+j] == 1){
                sum += 1;
            }
        }
    }

    return sum;
}

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL);

    cin >> N;

    for(int i=0; i<N; i++){ // 격자점 입력 받기
        for(int j=0; j<N; j++){
            cin >> arr[i][j];
        }
    }

    int M = 0;

    for(int i=0; i<N-2; i++){
        for(int j=0; j<N-2; j++){
            if(M < coin(i,j))
                M = coin(i,j);
        }
    }

    cout << M;
    return 0;
}

// 피드백
// 격자점 문제 풀이 시, 탐색 할 위치의 좌표를 인자로 받는 함수를 만들어서 풀이하기