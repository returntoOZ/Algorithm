//
// Created by 오지환 on 10/13/23.
//
#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

vector<pair<int,int>>v[10001];
bool visited[10001];
int endpoint;
int result;

void dfs(int node,int len)
{
    if(visited[node])
        return;
    visited[node]=true;
    if(result<len)
    {
        result=len;
        endpoint=node;
    }
    for(int i=0; i<v[node].size(); i++)
    {
        dfs(v[node][i].first, len+v[node][i].second);
    }
}

int main()
{

    int N,a,b,c;
    cin >> N;
    for(int i=1; i<N; i++)
    {
        cin >> a >> b >> c;
        v[a].push_back({b,c});
        v[b].push_back({a,c});
    }

    dfs(1,0);//가장멀리 있는 점 구하기(어느 정점을 넣든 상관없음)
    memset(visited,false,sizeof(visited));
    dfs(endpoint,0);//최대거리(지름)구하기
    cout << result;

    return 0;
}