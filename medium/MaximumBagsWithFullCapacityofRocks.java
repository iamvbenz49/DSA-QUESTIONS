class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] temp = new int[rocks.length];
        for(int i =0 ;i<capacity.length;i++){
            temp[i] = capacity[i]-rocks[i];
        }
        Arrays.sort(temp);
        int res = 0;
        for(int i=0;i<temp.length;i++){
            if(additionalRocks>=temp[i]){
                additionalRocks = additionalRocks - temp[i];
                temp[i] = 0;
                res++;
            }
            else{
                break;
            }
        }
        return res;
    }
}
