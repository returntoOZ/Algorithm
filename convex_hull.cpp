//
// Created by 오지환 on 11/13/23.
//
#include "iostream"
#include "cmath"
#include "stack"
#include "algorithm"
using namespace std;

struct Point{
    int x, y;
    int p, q;
    Point() : x(0), y(0), p(1), q(0) {}
    Point(int x1, int y1) : x(x1), y(y1), p(1), q(0) {}
};

long long ccw(Point& A, Point& B, Point& C){
    return (B.x-A.x)*(C.y-A.y) - (B.y - A.y)*(C.x - A.x);
}

int main(){
    int N;
    cin >> N;
    Point p[1000];
    for(int i=0; i<N; i++){
        int x, y;
        cin >> x >> y;
        p[i] = Point(x,y);
    }
}