#include "iostream"
#include "queue"
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    priority_queue<int, vector<int>, greater<int>> pq;

    int N, num;
    cin >> N;

    for(int i=0;i<N;i++){
        cin >> num;
        pq.push(num);
    }
    if(N == 1)
        cout << num;
    else{
        int sum = 0;

        for(int i=1; i<N-1; i++){
            int cur1 = pq.top();
            pq.pop();
            int cur2 = pq.top();
            pq.pop();
            int cur = cur1 + cur2;
            pq.push(cur);
            sum += cur;
        }

        cout << sum;
    }
}