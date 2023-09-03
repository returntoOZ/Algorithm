//
// Created by 오지환 on 2023/09/03.
//
#include<iostream>
using namespace std;

int T;
string s, c;
int check[26];
int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> T;

    while (T--) {
        bool flag = true;

        cin >> s >> c;

        if (s.size() != c.size()) {
            cout << "F\n";
        }
        else {
            for (int i = 0; i < s.size(); i++) {
                check[s[i]-'a']++;
            }

            for (int i = 0; i < c.size(); i++) {
                check[c[i]-'a']--;
            }

            for (int i = 0; i < 26; i++) {
                if (check[i] != 0) {
                    cout << "F\n";
                    flag = false;
                    break;
                }
            }

            if (flag)
                cout << "T\n";
        }

        for (int i = 0; i < 26; i++) {
            check[i] = 0; // reset
        }
    }
}
/*
3
components
psntemonco
components
psntemonca
aberook
okapril

T
F
F
*/

/*
30
q
q
tjdutt
uhj
sd
fwvsjvnvfb
jykpor
kjorpy
czce
xmsk
nds
ue
vouokeln
eovonkul
igszn
qxymb
os
hleeqwclzc
d
d
zj
pvkvd
k
k
zoblmox
luazwme
rar
rqg
nmuq
qnum
nwxqk
zakuskxttf
sgx
wgm
lfgpgia
fiapggl
yb
ew
ysw
wsy
heccapr
zz
z
g
gh
gh
x
ucbovlr
dsxawmvvq
kfnirzgdv
hkelnjey
lejkeyhn
culevhlhul
dnfnxnzlsz
ofufrm
cq
qcwxr
xqrwc
vorfq
lbmf
*/

/*
T
F
F
T
F
F
T
F
F
T
F
T
F
F
T
F
F
T
F
T
F
F
T
F
F
T
F
F
T
F
*/