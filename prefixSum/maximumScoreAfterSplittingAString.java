class Solution {
    public int maxScore(String s) {
        int ones = 0, zeros = s.charAt(0)=='0'?1:0,  max = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='1')
                ones++;
        }
        max = zeros + ones;
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)=='1')
                ones--;
            else
                zeros++;
            max = Math.max(max,zeros+ones);
        }
        return max;
    }
}