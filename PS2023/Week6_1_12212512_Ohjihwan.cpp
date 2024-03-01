//
// Created by 오지환 on 10/13/23.
//
#include <iostream>
#include <deque>
#include <cstring>

using namespace std;

int T;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin >> T;

    for (int t = 0; t < T; t++) {
        int n, m;
        bool i_check[100001] = {false,};
        bool b_check[100001] = {false,};
        cin >> n >> m;
        int inha = 0;
        int dragon = 0;
        for (int i = 0; i < m; i++) {
            int a,b;
            cin >> a >> b;
            i_check[a] = true;
            b_check[b] = true;
            if (a >= b) {
                inha++;
            } else {
                dragon++;
            }
        }
        deque<int> inha_card;
        deque<int> dragon_card;
        for (int i = 1; i <= n; i++) {
            if (!i_check[i]) {
                inha_card.push_back(i);
            }
            if(!b_check[i]){
                dragon_card.push_back(i);
            }
        }
        for (int i = 0; i < n - m; i++) {
            if (inha_card.front() >= dragon_card.back()) {
                inha++;
                inha_card.pop_front();
                dragon_card.pop_back();
            } else if (inha_card.back() < dragon_card.front()) {
                dragon++;
                dragon_card.pop_back();
                inha_card.pop_front();
            } else if (inha_card.back() < dragon_card.back()) {
                dragon++;
                dragon_card.pop_back();
                inha_card.pop_front();
            } else if (inha_card.back() >= dragon_card.back()) {
                inha++;
                inha_card.pop_back();
                dragon_card.pop_back();
            }
        }
        if(inha>dragon) {
            cout << 1 << "\n";
        } else {
            cout << 0 << "\n";
        }
        memset(i_check, false, n + 1);
        memset(b_check, false, n + 1);
    }
}