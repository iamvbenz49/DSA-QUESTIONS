#include <bits/stdc++.h>
using namespace std;

void solve() {
    int  x, y;
    cin >> x >> y;
    int minimumNumber = min(x, y);
    cout << -x + y; 

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
