import java.util.Arrays;

class Solution {
    public long pickGifts(int[] gifts, int k) {  
        long sum = 0;
        for(int i=gifts.length-1;0<k;k--){
            Arrays.sort(gifts);
            gifts[i] = (int)Math.floor(Math.sqrt((double)gifts[i]));
            // System.out.println(Arrays.toString(gifts));
        }
        for(int i=0;i<gifts.length;i++){
            sum+=gifts[i];
        }
        return sum;
    }
}
