//first approach
class Solution {
    public boolean isUgly(int n) {
        while(n>1){
            if(n%2==0)n/=2;
            else if(n%3==0)n/=3;
            else if(n%5==0)n/=5;
            else{
                return false;
            }
        }
        return n>0;
    }
}

//second approach
class Solution {
    public boolean isUgly(int n) {
        while(n%2==0 && n!=0){
            n/=2;
        }
        while(n%3==0 && n!=0){
            n/=3;
        }
        while(n%5==0 && n!=0){
            n/=5;
        }
        return n==1;
    }
}
