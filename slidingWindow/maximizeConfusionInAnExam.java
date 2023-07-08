class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(checkMax(answerKey,k,'F'),checkMax(answerKey,k,'T'));
    }
    public int checkMax(String answerKey,int k,char c){
        int left=0,right,max = 0;
        for(right =0;right<answerKey.length();right++){
            char rightCurr = answerKey.charAt(right);
            if(rightCurr==c){
                k-=1;
            }
            
            while(k<0){
                char leftCurr = answerKey.charAt(left);
                if(leftCurr==c){
                    k+=1;
                }
                left++;
            }
            max = Math.max(right-left+1,max);
        }
        return max;
    }
}
