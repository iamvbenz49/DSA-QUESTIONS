#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;
    cout << 1;
    for(int i = 1; i < n; i++) {
        cout << 0;
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
