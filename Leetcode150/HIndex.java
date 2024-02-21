class Solution {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length+1];
        for(int citation:citations){
            if(citation>=citations.length)
                count[citations.length]++;
            else
                count[citation]++;
        }
        int total = 0;
        for(int i=citations.length;i>=0;i--){
            total += count[i];
            if(total>=i) return i;
        }
        return 0;
    }
}
