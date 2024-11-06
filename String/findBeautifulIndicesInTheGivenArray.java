class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> aList = KMP(a + " " + s, a.length()), bList = KMP(b + " " + s, b.length());
        if(aList.size() == 0 || bList.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < aList.size(); i++) {
            int ceilValue = ceil(bList, aList.get(i));
            if( Math.abs(bList.get(ceilValue) - aList.get(i)) <= k) {
                res.add(aList.get(i));
                continue;
            }
            if(ceilValue != 0) {
                if(Math.abs(bList.get(ceilValue - 1) - aList.get(i)) <= k) {
                    res.add(aList.get(i));
                    continue;
                }
            } 
            if(ceilValue != bList.size() - 1) {
                if(Math.abs(bList.get(ceilValue + 1) - aList.get(i)) <= k) {
                    res.add(aList.get(i));
                }
            }
        }
        return res;
    }
    public List<Integer> KMP(String s, int len) {
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        int[] LPS = new int[n];

        for(int i = 1; i < n; i++) {
            int prev_index = LPS[i - 1];
            while(prev_index > 0 && s.charAt(prev_index) != s.charAt(i)) {
                prev_index = LPS[prev_index - 1];
            }
            if(s.charAt(prev_index) == s.charAt(i)) {
                LPS[i] = prev_index + 1;
            }
            if(i > len && LPS[i] == len) {
                res.add(i - 2*len);
            }
        }
        return res;
    }
    public int ceil(List<Integer> list, int target) {
        int start = 0, end = list.size() - 1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}