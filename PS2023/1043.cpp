#include "iostream"
#include "vector"
using namespace std;

int N, M, tnum, pnum, cnt=0;
int parent[51];
int pt[51];

vector<int> party[51];

int find(int x){
  if(parent[x] == x) return x;
  return parent[x]=find(parent[x]);
}
void uni(int x, int y){
  x = find(x);
  y = find(y);
  if(x==y)return;
  parent[y] = x;
}

int main(){
  ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

  cin >> N >> M;
  cin >> tnum;

  for(int i=1; i<=N; i++){
    parent[i]=i;
  }

  for(int i=0; i<tnum; i++){
    int people;
    cin >> people;
    pt[i] = people;
  }

  for(int i=0; i<M; i++){
    cin >> pnum;

    for(int j=0; j<pnum; j++){
      int people;
      cin >> people;
      party[i].push_back(people);
    }
  }

  for(int i=0; i<M; i++){
    int cur = party[i][0];
    for(int j=1; j<party[i].size(); j++){
      int comp = party[i][j];
      uni(cur, comp);
    }
  }

  for(int i=0; i<M; i++){
    bool flag = true;
    for(int j=0; j<party[i].size(); j++){
      int comp1 = party[i][j];
      for(int k=0; k<tnum; k++){
        int comp2 = pt[k];
        if(find(comp1) == find(comp2)){
          flag = false;
          break;
        }
      }
    }
    if(flag) cnt++;
  }

  cout << cnt;
}