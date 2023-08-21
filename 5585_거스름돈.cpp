#include "iostream"
#include "algorithm"
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N;
    cin >> N;

    int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0; //500 100 50 10 5 1
    int sum = 1000 - N;

    while(sum!=0){
        if(sum >= 500){
            a += sum / 500;
            sum -= (sum / 500) * 500;
        }else if(sum >= 100){
            b += sum / 100;
            sum -= (sum / 100) * 100;
        }else if(sum >= 50){
            c += sum / 50;
            sum -= (sum / 50) * 50;
        }else if(sum >= 10){
            d += sum / 10;
            sum -= (sum / 10) * 10;
        }else if(sum >= 5){
            e += sum / 5;
            sum -= (sum / 5) * 5;
        }else{
            f += sum;
            sum -= sum;
        }
    }

    cout << a + b + c + d + e + f;
}