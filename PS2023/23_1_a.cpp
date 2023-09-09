//
// Created by 오지환 on 2023/09/03.
//
#include<iostream>
using namespace std;

int T;
string s, c;
int check[26];
int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> T;

    while (T--) {
        bool flag = true;

        cin >> s >> c;

        if (s.size() != c.size()) {
            cout << "F\n";
        }
        else {
            for (int i = 0; i < s.size(); i++) {
                check[s[i]-'a']++;
            }

            for (int i = 0; i < c.size(); i++) {
                check[c[i]-'a']--;
            }

            for (int i = 0; i < 26; i++) {
                if (check[i] != 0) {
                    cout << "F\n";
                    flag = false;
                    break;
                }
            }

            if (flag)
                cout << "T\n";
        }

        for (int i = 0; i < 26; i++) {
            check[i] = 0; // reset
        }
    }
}
/*
3
components
psntemonco
components
psntemonca
aberook
okapril

T
F
F
*/