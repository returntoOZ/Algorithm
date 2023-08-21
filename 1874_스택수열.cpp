#include "iostream"
#include "vector"
using namespace std;

int arr[100000]; // 수열 저장용 배열
int n, total=0, sum=0, num = 0; // 전체 연산자 개수, +/- 부호 증감
bool flag = false;
vector<char> ans;

void calc(int cur){
    if(total>2*n || sum < 0){
        flag = true;
        return;
    }
    if(cur <= num){
        total++;
        sum--;
        ans.push_back('-');
        return;
    }
    total++;
    sum++;
    num++;
    ans.push_back('+');
    calc(cur);
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n; // 8

    for(int i=0; i<n; i++){
        cin >> arr[i]; // 4 3 6 8 7 5 2 1
    }

    for(int i=0; i<n; i++){
        calc(arr[i]);
    }

    if(flag)
        cout << "NO";
    else{
        for(auto a : ans){
            cout << a << "\n";
        }
    }
}