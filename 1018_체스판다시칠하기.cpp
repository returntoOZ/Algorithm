#include "iostream"
#include "vector"
using namespace std;

string chess[50]; // 체스판
int ans = 9999999; // 결과 저장

string WB[8] = {
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW"
};

string BW[8] = {
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB"
};

int Wcheck(int x, int y){ // white로 시작하는 check판 체크용
    int changes = 0;

    for(int i=0; i< 8; i++){
        for(int j=0; j<8; j++){
            if(WB[i][j] != chess[x+i][y+j])
                changes++;
        }
    }

    return changes;
}

int Bcheck(int x, int y){ // w로 시작하는 check판 체크용
    int changes = 0;

    for(int i=0; i< 8; i++){
        for(int j=0; j<8; j++){
            if(BW[i][j] != chess[x+i][y+j])
                changes++;
        }
    }

    return changes;
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N, M, changes = 0;
    cin >> N >> M;

    for(int i=0; i<N; i++){
        cin >> chess[i]; // chess판 입력받기
    }

    for(int i=0; i<=N-8; i++){
        for(int j=0; j<=M-8; j++){
            int a = Wcheck(i, j);
            int b = Bcheck(i, j);

            if(ans > a) ans = a;
            if(ans > b) ans = b;
        }
    }

    cout << ans;
}