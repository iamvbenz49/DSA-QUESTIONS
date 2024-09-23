#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, x, y;
    cin >> n >> x >> y;
    int minimumNumber = min(x, y);
    cout << (int)ceil(n/(minimumNumber*1.0)); 
    // another trick to get ceil
    // (n - minimumNumber + 1)/minimumNumber
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
