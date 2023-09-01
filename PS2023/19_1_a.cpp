//
// Created by 오지환 on 2023/08/31.
//
#include "iostream"
using namespace std;

int main(){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int T, N, a, b; // a : 발생 시간, b : 실행 시간
    cin >> T;

    while(T--){
        cin >> N;

        int total = 0; // total : 누적 시간
        int cwt;// cwt : 현재 waiting time
        int twt = 0, trt = 0; // twt : 누적 waiting time, trt : 누적 response time

        for(int i=0; i<N; i++){
            cin >> a >> b;

            if(total == a){
                cwt = 0;
                trt += b;
                total += b;
            }else if(total < a){
                cwt = 0;
                trt += b;
                total = a + b;
            }
            else{
                cwt = total - a;
                twt += cwt;
                trt += (cwt + b);
                total += b;
            }
        }

        cout << twt/N << " " << trt/N;
    }
}
/*
2
2
0 10
2 10
3
1 3
2 4
3 7
*/
