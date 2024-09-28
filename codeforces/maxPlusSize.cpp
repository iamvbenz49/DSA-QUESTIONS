#include <bits/stdc++.h>
using namespace std;

int max(int x, int y) {
    return x>y?x:y;
}
void solve() {
    int  n, om = 0, em = 0;
    cin >> n;
    for(int i = 0; i < n; i++) {
        int c;
        cin >> c;
        if(i%2) {
            om = max(om,c);
        } else {
            em = max(em, c);
        }
    }
    if(n%2 == 0) {
        cout << max(om, em) + (n/2);
    } else {
        cout << max(
            em + (n/2) + (n%2),
            om + (n/2)
        );
    }
}  

int main() {
    int testcases;
    cin >> testcases;
    
    while (testcases-- > 0) {
        solve();
        if(testcases != 0) cout << endl;  
    }
    return 0;
}
