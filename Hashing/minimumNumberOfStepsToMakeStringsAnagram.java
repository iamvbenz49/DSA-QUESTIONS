class Solution {
    public int minSteps(String s, String t) {
        int[] map = new int[26];
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-97]++;
        }
        for(int i=0;i<t.length();i++){
            map[t.charAt(i)-97]--;
        }
        int res = 0;
        for(int num:map) if(num>0)res += num;
        return res;
    }
}
