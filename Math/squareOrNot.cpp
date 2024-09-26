#include <bits/stdc++.h>
#include <string>
using namespace std;

void solve() {
    int  n;
    cin >> n;
    string s;
    cin.ignore();
    getline(cin, s);
    if(sqrt(n) != floor(sqrt(n))) {
        cout << "NO";
        return;
    }

    int checkNumber = sqrt(n);
    std::string str = "";
    for(int i = 0; i < checkNumber; i++) {
        for(int j = 0; j < checkNumber; j++) {
            if(i == 0 || j == 0 || i == checkNumber-1 || j == checkNumber-1) {
                str += "1";
            } else {
                str += "0";
            }
        }
    }
    // cout << str << " " << s << n << endl;
    if(str == s) {
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
