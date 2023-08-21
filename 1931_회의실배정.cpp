#include "iostream"
#include "algorithm"
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    vector<pair<int,int>> room;

    int N, start, end, count = 1; // 회의의 수 , 시작 시간, 종료 시간, 비교 변수
    cin >> N;

    for(int i=0; i<N; i++){
        cin >> start >> end;
        room.push_back(make_pair(end, start));
    }

    sort(room.begin(), room.end());

    int time = room[0].first;

    for(int i=1; i<N; i++){
        if(time <= room[i].second){
            time = room[i].first;
            count++;
        }
    }

    cout << count;
}