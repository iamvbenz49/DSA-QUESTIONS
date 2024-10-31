#include <bits/stdc++.h>
using namespace std;

int max(int x, int y) {
    return x>y?x:y;
}

int min(int x, int y) {
    return x<y?x:y;
}
void solve() {
    int a, b;
    cin >> a >> b;
    
    if(a >= b) {
        cout << a;
        return;
    }
    int res = a - (b - a);
    if(res <= 0) {
        cout << 0;
    } else {
        cout << res;
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
