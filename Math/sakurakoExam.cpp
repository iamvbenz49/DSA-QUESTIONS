#include <bits/stdc++.h>
using namespace std;

void solve() {
    int  x, y;
    cin >> x >> y;
    if(x%2 == 0 && y%2 == 0) {
        cout << "YES";
    } else if(x!= 0 && x%2 == 0 && y%2 == 1) {
        cout << "YES";
    } else {
        cout << "NO";
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
