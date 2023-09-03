//
// Created by 오지환 on 2023/09/03.
//
#include<iostream>
using namespace std;
typedef unsigned long long ll;

int T, N;
ll dp[10000001];

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> T;

    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= 10000000; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2])% (1000000007);
    }

    while (T--) {
        cin >> N;
        cout << (dp[N] % (1000000007))<< "\n";
    }
}
/*
20
32
9
26
11
5
30
20
50
15
42
47
18
41
40
28
43
19
13
25
44
*/

/*
*
3524578
55
196418
144
8
1346269
10946
365010934
987
433494437
807526948
4181
267914296
165580141
514229
701408733
6765
377
121393
134903163
*/