//
// Created by 오지환 on 11/10/23.
//
#include <iostream>
#include "map"
#include "queue"
using namespace std;

#define EPS 0.05  // 클러스터링에 사용할 인접 노드 탐색 거리
#define MIN_CLUSTER 3  // 군집을 이루는 최소 개수

// 우리가 다룰 킥보드 엔티티
typedef struct Kickboard {
    int id;
    double lat;
    double lng;
    int cluster_number;
    bool danger;
};
typedef pair<double, int> pdi;

map<int, Kickboard> kickboardList;  // 킥보드 노드 셋, { id, 엔티티 }로 구성

vector<pdi> adj[1001];  // 인접 리스트
bool visited[1001] = {};  // 노드 방문 여부, 중복 탐색 방지하기 위해 필수

int cluster_count = 0;

void bfs(int init) {
    queue<int> q;
    vector<int> cluster_sequence;
    q.push(init);
    visited[init] = true;
    bool isDangerSequence = false;

    while (!q.empty()) {
        int x = q.front();
        q.pop();
        cluster_sequence.push_back(x);

        for (pdi p : adj[x]) {  // x의 인접 노드들을 가장 가까운 순으로 탐색
            if (p.first > EPS) break;  // 노드 간 거리가 EPS보다 커지면 탐색 종료
            int nxt = p.second;
            if (visited[nxt]) continue;  // 방문한 노드면 군집화 대상에서 제외
            q.push(nxt);
            visited[nxt] = true;
            // 군집에 위험 킥보드가 껴 있으면 종료 플래그 활성화
            if (kickboardList[nxt].danger) isDangerSequence = true;
        }
    }

    // 군집을 이루는 최소 개수를 만족하지 않으면 종료
    if (cluster_sequence.size() < MIN_CLUSTER) return;
    // 군집에 위험 킥보드가 껴 있으면 종료
    if (isDangerSequence) return;

    cluster_count++;  // 군집 번호 지정, 1,2,3,4,...
    for (int v : cluster_sequence) {
        kickboardList[v].cluster_number = cluster_count;
    }
}

// 노드 a와 노드 b간 거리를 계산하는 함수
double calc_dist(Kickboard a, Kickboard b) {
    double ret = pow(a.lat - b.lat, 2) + pow(a.lng - b.lng, 2);
    ret = sqrt(ret);
    return ret;
}

void dbscan() {
    // 1. 노드 간 거리 인접 리스트에 저장
    for (auto u : kickboardList) {
        for (auto v : kickboardList) {
            if (u.first <= v.first) continue;
            double len = calc_dist(u.second, v.second);
            adj[u.first].push_back({len, v.first});
            adj[v.first].push_back({len, u.first});
        }
    }

    // 2. 인접 리스트를 거리 별 정렬
    for (int i = 0; i <= 1000; i++) {
        sort(adj[i].begin(), adj[i].end());
    }

    // 3. BFS 이용 클러스터링 진행
    for (int i = 0; i <= 1000; i++) {
        if (visited[i]) continue;
        bfs(i);
    }
}

int main() {
    // before: kickboardList -> all cluster_number = -1
    dbscan();
    // after: kickboardList -> cluster_number data assigned
}
