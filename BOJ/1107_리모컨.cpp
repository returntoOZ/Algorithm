//
// Created by 오지환 on 2023/09/26.
//
#include "iostream"
#include "vector"
using namespace std;

string N, digt;
int M, cnt;
char n;
vector<char> num;
vector<int> ans;
bool flag = true, bs, check[10];

void make(int cur){
    if(cur == N.size()){
        return;
    }

    if(flag){ // 앞 자리 수와 같은게 있을 때
        for(int i=0; i<10; i++){
            if(check[i]){

            }
        }
    }else{ // 앞 자리 수와 같은게 없을 때!
        if(N[cur-1] > digt[cur-1]){
            for(int i=0; i<N.size()-cur; i++){
                digt += num[M-1];
            }
            ans.push_back(stoi(digt));

            digt += num[M-1]; // 가지고 있는 수 중 가장 큰 것
            make(cur+1);
        }else{
            digt += num[0]; // 가지고 있는 수 중 가장 작은 것
            make(cur+1);
        }
    }
}

int main(){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> N >> M;

    memset(check, true, 10);

    while(M--){
        cin >> num;
        check[num] = false;
    }

    if(N == "100"){
        cout << 0;
        return 0;
    }

    make(0);

    cout << ans;
}