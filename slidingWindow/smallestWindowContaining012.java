class Solution {
    public int smallestSubstring(String S) {
        int left = 0, right = 0;
        int zeros = 0, ones = 0, twos = 0;
        int res = (int)1e6;
        while(right<S.length()){
            char c = S.charAt(right);
            if(c=='0')zeros++;
            else if(c=='1')ones++;
            else twos++;
            while(zeros>0 && ones>0 && twos>0){
                res = Math.min(res,right-left+1);
                char k = S.charAt(left);
                if(k=='0')zeros--;
                else if(k=='1')ones--;
                else twos--;
                left++;
            }
            right++;
        }
        return res==(int)1e6?-1:res;
    }
};
