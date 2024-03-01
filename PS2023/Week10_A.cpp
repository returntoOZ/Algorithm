#include "iostream"
using namespace std;

bool map[1000][1000];

int main(){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int T; // test case의 수
    cin >> T;

    while (T--){
        int N; // 입력 받을 종이의 개수
        cin >> N;
        for(int i=0; i<N; i++){
            int x, y, w, h; // X : x좌표, Y : y좌표, w : 가로 길이, h : 세로 길이
            cin >> x >> y >> w >> h;
            for(int i=0; i<w; i++){
                for(int j=0; j<h; j++){
                    if(!map[x+i][y+j]) map[x+i][y+j] = true; //
                }
            }
        }

        int cnt = 0;

        for(int i=0; i<1000; i++){
            for(int j=0; j<1000; j++){
                if(map[i][j]) {
                    cnt++;
                    map[i][j] = false;
                }
            }
        }

        cout << cnt << "\n";
    }
}