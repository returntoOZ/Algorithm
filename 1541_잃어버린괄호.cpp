#include "iostream"
using namespace std;

string input, num ="";
int sum = 0;
bool flag;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> input;

    for(int i=0; i<input.size(); i++){
        if(input[i] == '-' || input[i] == '+' || i == input.size() - 1){
            if(i == input.size() - 1)
                num += input[i];

            if(flag){ // - 가 한번 이상 나왔을 때
                sum -= stoi(num);
            }
            else{
                sum += stoi(num);
            }

            num = ""; // 초기화

            if (!flag && input[i] == '-') // - check용
                flag = true;
        }
        else{
            num += input[i];
        }
    }

    cout << sum;
}