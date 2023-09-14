//
// Created by 오지환 on 2023/09/12.
//
#include "iostream"
using namespace std;
#define INF ~0U >> 2;

int dp[1001][3]; // n번째 집까지의 최소 비용
int color[1001][3]; // n번째 집을 칠하는 비용 (R:0, G:1, B:2)
int N;

int main(){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin >> N;

    for(int i=1; i<=N; i++){
        for(int j=0; j<3; j++){
            cin >> color[i][j];
            dp[i][j] = INF;
        }
    }

    dp[1][0] = color[1][0];
    dp[1][1] = color[1][1];
    dp[1][2] = color[1][2];
    // base value

    for(int i=2; i<=N; i++){
        for(int j=0; j<3; j++){
            for(int k=0; k<3; k++){
                if(k != j){
                    dp[i][j] = min(dp[i][j], dp[i-1][k] + color[i][j]);
                }
            }
        }
    }

    cout << min(dp[N][0], min(dp[N][1], dp[N][2]));
}

/*
#include <iostream>

using namespace std;

int d[1002][4];

int main(){
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;
	int r,g,b;
	cin >> r >> g >> b;
	d[1][1] = r; d[1][2] = g; d[1][3] = b;
	for(int i=2; i<=n; ++i){
		cin >> r >> g >> b;
		d[i][1] = min(d[i-1][2], d[i-1][3]) + r;
		d[i][2] = min(d[i-1][1], d[i-1][3]) + g;
		d[i][3] = min(d[i-1][1], d[i-1][2]) + b;
	}
	cout << min(min(d[n][1], d[n][2]), d[n][3]);
}
 * */

/*
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n;
	cin >> n;

	vector<vector<int>> colorCost(n, vector<int>(3));
	vector<vector<int>> findCost(n, vector<int>(3));

	for (int i = 0; i < n; i++) {
		cin >> colorCost[i][0] >> colorCost[i][1] >> colorCost[i][2];
	}

	findCost[0] = colorCost[0];

	for (int i = 1; i < n; i++) {
		findCost[i][0] = min(findCost[i - 1][1], findCost[i - 1][2]) + colorCost[i][0];
		findCost[i][1] = min(findCost[i - 1][0], findCost[i - 1][2]) + colorCost[i][1];
		findCost[i][2] = min(findCost[i - 1][1], findCost[i - 1][0]) + colorCost[i][2];
	}

	cout << min(min(findCost[n - 1][1], findCost[n - 1][0]), findCost[n - 1][2]);

}
 * */