class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = square(slow);
            fast = square(square(fast));
        }while(slow!=fast);
        return slow==1;
    }
    public int square(int n){
        int s = 0;
        while(n!=0){
            s+=(n%10)*(n%10);
            n/=10;
        }
        return s;
    }
}
