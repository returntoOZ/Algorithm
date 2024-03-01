#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;

int T, C;
vector<char> ans;
string N;

char num[10];

void bt(int n, bool fl){
    if(n == N.size()){
        for(auto a: ans){
            cout << a;
        }
        cout << "\n";
        return;
    }
    if(fl){
        ans.push_back(num[C-1]);
        bt(n+1, fl);
        ans.pop_back();
        n -= 1;
    }
    for(int i=0; i<N.size(); i++){
        for(int j=0; j<C; j++){
            if(N[i] == num[C-1-j]){
                ans.push_back(num[C-1-j]);
                bt(n+1, fl);
                ans.pop_back();
                n -= 1;
            }else if(N[i] > num[C-1-j]){
                ans.push_back(num[C-1-j]);
                fl = true;
                bt(n+1, fl);
                fl = false;
                ans.pop_back();
                n -= 1;
            }
        }
    }
}

int main() {
    cin >> T;

    while (T--) {
        cin >> N >> C;

        for (int i = 0; i < C; i++) {
            cin >> num[i];
        }

        sort(num, num + C);

        bt(0, false);
    }
}
/*
2
7596 3
3 6 9
123456789 2
8 4
*/