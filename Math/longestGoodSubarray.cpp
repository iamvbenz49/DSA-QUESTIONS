#include <bits/stdc++.h>
using namespace std;

void solve() {
    int  x, y,  i = 1;
    cin >> x >> y;
    while(x + i <= y) {
        x+=i;
        i+=1;
    }
    cout << i;
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
