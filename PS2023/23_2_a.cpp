#include <iostream>
#include <string>
#include <map>
using namespace std;

map<int, string> dict1;
map<string, int> dict2;

int T, N, C;
string s;

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> T;

    while (T--) {
        cin >> N;

        for (int i = 1; i <= N; i++) {
            cin >> s;
            dict1[i] = s;
            dict2[s] = i;
        }

        cin >> C;

        for (int i = 0; i < C; i++) {
            cin >> s;
            if (s[0] - '0' < 10) { // 주어진 값이 숫자 일 때
                cout << dict1[stoi(s)] << "\n";
            }
            else { // 주어진 값이 문자열 일 때
                cout << dict2[s] << "\n";
            }
        }
    }

}