class Solution {
    public int numberOfSteps(int num) {
        if(function(num)==0){
            return 0;
        }
        return function(num)-1;
    }
    static int function(int num){
        if(num==0){
            return 0;
        }
        if(num%2==1){
            return 2+function((num-1)/2);
        }
        else{
            return 1+function(num/2);
        }
    }
}
