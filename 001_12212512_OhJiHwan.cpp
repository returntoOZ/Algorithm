#include "iostream"
#define MAX 2147483647
using namespace std;
int A[1001]; // 행렬들의 차원을 저장하기 위한 배열
int m[1001][1001]; // i번째 행렬과 j번째 행렬을 곱했을 때의 최소 연산 횟수 저장 배열
int s[1001][1001]; // split index를 저장하기 위한 배열

int T, n, D; // T: 질의의 수, n: 행렬의 개수, D: 소수

void MCM(int n) { // 행렬 곱셈의 최소 연산 수 계산 함수
    for(int l=1; l<=n-1; l++){ // bottom up 풀이를 위한 for문 설계 (l로 j 변수 control)
        for(int i=1; i<=n-l; i++){ // i : column
            int j = i + l; // j : row (i < j)

            m[i][j] = MAX; // m[i][j]의 최소 값을 탐색하기 위해 int_Max 값으로 m[i][j] 초기화

            for(int k=i; k<j; k++){
                if(m[i][j] > m[i][k] + m[k+1][j] + A[i-1]*A[k]*A[j]) { // 현재 m값보다 k번째에서 split한 m값이 더 작다면
                    m[i][j] = m[i][k] + m[k+1][j] + A[i-1]*A[k]*A[j]; // m값을 k번째에서 split하여 연산한 값으로 교체
                    s[i][j] = k; // 최소 m[i][j] 연산 수가 나오게 된 split index 값 저장
                }
            }

        }
    }
}

int ordering(int i, int j){ // 행렬 곱셈 연산 순서 계산 함수
    if(i==j) return i; // base condition (본인 idx를 만나면 본인 idx 리턴)
    return  (ordering(i, s[i][j]) * ordering(i, s[i][j]) + ordering(s[i][j] + 1, j) * ordering(s[i][j] + 1, j))%D; // (x^2 + y^2) % D 를 구하는 recursion
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> T; // 질의의 수 입력 받기

    while(T--){
        cin >> n >> D; // 행렬의 수 & 소수 입력 받기
        for(int i=0; i<=n; i++){
            cin >> A[i]; // 행렬의 차원 입력 받기
        }

        MCM(n); // 최소 연산 수 계산

        cout << m[1][n] << "\n" << ordering(1, n) << "\n";// 최소 곱셉 연산 수 && 행렬 곱셈 순서 결과 출력

        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){ // 이전 testCase에서의 계산 값 clear하는 과정
                m[i][j] = 0;
                s[i][j] = 0;
            }
        }
    }
}