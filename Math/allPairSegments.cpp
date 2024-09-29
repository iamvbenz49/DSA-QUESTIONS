#include <bits/stdc++.h>
using namespace std;

void solve() {
    long long NUMBER_OF_INPUTS, QUERIES;  // Use long long
    cin >> NUMBER_OF_INPUTS >> QUERIES;

    vector<long long> points(NUMBER_OF_INPUTS);  // Use long long
    for(long long i = 0; i < NUMBER_OF_INPUTS; i++) {
        cin >> points[i];
    }

    map<long long, long long> lineCount;  // Use long long
    long long lines;

    for(long long i = 0; i < NUMBER_OF_INPUTS; i++) {
        lines = (i + 1) * (NUMBER_OF_INPUTS - i) - 1; // Line count logic
        lineCount[lines]++;

        if(i > 0) {
            long long additionalLines = (i) * (NUMBER_OF_INPUTS - i); // Handle case for adjacent points
            lineCount[additionalLines] += (points[i] - points[i - 1]) - 1;
        }
    }

    for(long long i = 0; i < QUERIES; i++) {
        long long q;  // Properly initialize and read q
        cin >> q;

        if(lineCount.find(q) == lineCount.end()) {
            cout << 0 << " ";
        } else {
            cout << lineCount[q] << " ";
        }
    }
}

int main() {
    int testcases;
    cin >> testcases;

    while (testcases-- > 0) {
        solve();
        if(testcases != 0) {
            cout << endl;
        }
    }
    return 0;
}
