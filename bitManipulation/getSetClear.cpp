class Solution {
  public:
    void bitManipulation(int num, int i) {
        i--;
        // never solve bit qns in java
        // Get the value of the i-th bit (1 if set, 0 if not)
        int get = (num & (1 << i)) != 0 ? 1 : 0;
        
        // Set the i-th bit
        int set = num | (1 << i);
        
        // Clear the i-th bit (set to 0)
        int clear =  set ^ (1<<i);

        // Output the results
        cout << get << " ";
        cout << set << " ";
        cout << clear;
    }
};