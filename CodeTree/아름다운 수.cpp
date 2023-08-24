#include <iostream>
using namespace std;
int N, ans;

void bt(int cur) {
    if (cur < 0)
        return;

    if (cur == 0) {
        ans++;
        return;
    }
        
    for (int i = 1; i <= 4; i++) {
        if (i == 1)
            bt(cur - 1);
        else if (i == 2)
            bt(cur - 2);
        else if (i == 3)
            bt(cur - 3);
        else
            bt(cur - 4);
    }
}

int main() {
    cin >> N;

    bt(N);

    cout << ans;
}
