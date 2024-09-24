class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for(String currentString: dictionary) {
            map.put(currentString, 1);
        }
        return find(dp, map, s, 0);
    }
    public int find(int[] dp, Map<String, Integer> map, String s, int index) {
        if(index == s.length()) return 0;
        if(dp[index] != -1) return dp[index];
        String str = "";
        int ans = (int)1e7;
        for(int i = index; i < s.length(); i++) {
            str = str + s.charAt(i);
            // if found in map, you can explore further or you can include and explore further else explore further
            if(map.containsKey(str)) {
                ans = Math.min(Math.min(ans, find(dp, map, s, i + 1)), str.length() + find(dp, map, s, i + 1));
            } else {
                ans = Math.min(ans, str.length() + find(dp, map, s, i + 1));
            }
        }
        return dp[index] = ans;
    }
}