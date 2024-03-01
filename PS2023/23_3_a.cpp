#include<iostream>
using namespace std;

int T, n, ax, bx, ay, by, cnt;

void f() {
    cnt = 0;
    int a, b, c, d; // x1 y1 x2 y2
    int h = n / 2;

    if (ax > h) {
        a = ax - 1 - h;
    }
    else {
        a = h - ax;
    }

    if (ay > h) {
        b = ay - 1 - h;
    }
    else {
        b = h - ay;
    }

    if (bx > h) {
        c = bx - 1 - h;
    }
    else {
        c = h - bx;
    }

    if (by > h) {
        d = by - 1 - h;
    }
    else {
        d = h - by;
    }

    // ��� ��ġ ���ϱ� ��

    if (ax == bx) { // x��ǥ�� ������ ��,
        if (b == d) {
            cnt = 0;
        }
        else {
            if (a < max(b, d)) {
                cnt = max(b, d) - a;
            }
            else
                cnt = 0;
        }
    }
    else if (ay == by) { // y��ǥ�� ������ ��,
        if (a == c) {
            cnt = 0;
        }
        else {
            if (b < max(a, c)) {
                cnt = max(a, c) - b;
            }
            else {
                cnt = 0;
            }
        }
    }
    else {
        if (a == c) {
            cnt += 0;
        }
        else {
            if (b < max(a, c)) {
                cnt += max(a, c) - b;
            }
            else {
                cnt += 0;
            }
        }

        if (b == d) {
            cnt += 0;
        }
        else {
            if (c < max(b, d)) {
                cnt += max(b, d) - c;
            }
            else
                cnt += 0;
        }
    }
}


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> T;

    while (T--) {
        cin >> n; // maze size

        cin >> ax >> ay >> bx >> by; // cordinate

        f();
        cout << cnt << "\n";
    }
}

/*
10
8
4 4 4 1
6
6 3 3 4
4
4 4 4 1
8
6 7 3 7
6
5 1 5 5
4
3 3 4 2
6
3 6 1 1
8
5 8 2 6
8
1 3 5 5
8
5 4 5 7
*/

/*
3
2
0
0
1
1
0
1
3
2

*/