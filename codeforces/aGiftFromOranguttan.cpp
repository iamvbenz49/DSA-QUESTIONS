#include <bits/stdc++.h>
using namespace std;

int max(int x, int y) {
    return x>y?x:y;
}

int min(int x, int y) {
    return x<y?x:y;
}
void solve() {
    int n;
    cin >> n;
    int arr[n], m = 0, s = 10000;
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
        m = max(m, arr[i]);
        s = min(s, arr[i]);
    }
    cout << (m - s) * (n - 1);
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
