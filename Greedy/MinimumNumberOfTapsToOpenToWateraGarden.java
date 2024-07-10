class Solution {
    public int minTaps(int n, int[] ranges) {
        List<int[]> tapRanges = new ArrayList<>();
        for(int i = 0; i < ranges.length; i++){
            if(ranges[i] == 0) continue;
            if(i - ranges[i] <= 0){
                tapRanges.add(new int[]{0, i + ranges[i]});
            } else {
                tapRanges.add(new int[]{i - ranges[i], i + ranges[i]});
            }
        }
        Collections.sort(tapRanges, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int cmp = Integer.compare(a[0], b[0]);
                if (cmp != 0) {
                    return cmp;
                } else {
                    return Integer.compare(b[1], a[1]);
                }
            }
        });
        if(tapRanges.size() == 0) return -1;
        int right = tapRanges.get(0)[1], taps = 1, end = 0;
        for(int i=0;i<tapRanges.size();i++)
        System.out.println(Arrays.toString(tapRanges.get(i)));
        for(int i = 1; i < tapRanges.size(); i++) {
            if(right >= n) return taps;
            if(tapRanges.get(i)[0] > right){
                if(tapRanges.get(i)[0] > end) return -1;
               // left = Math.min(left, tapRanges.get(i)[0]);
                right = end;
                taps++;
            }
            end = Math.max(end, tapRanges.get(i)[1]);
        }
        System.out.println(end + " " + taps);
        if(end < n) return -1;
        if(right < end) return taps + 1;
        return taps;
    }
}
