#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;
    char arr[n][4];

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < 4; j++) {
            cin >> arr[i][j];
        }
    }

    bool first = true;

    for(int i = n - 1; i >= 0; i--) { 
        for(int j = 0; j < 4; j++) {
            
            if(arr[i][j] == '#') {
                if (!first) cout << " "; 
                cout << j + 1;  
                first = false;
                break;
            }
        }
        
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
