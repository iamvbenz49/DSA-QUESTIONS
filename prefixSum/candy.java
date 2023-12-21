// TC - O(3N) SC - O(2N)

class Solution {
    static int minCandy(int N, int ratings[]) {
        int[] candy = new int[N];
        Arrays.fill(candy,1);
        for(int i=1;i<N;i++){
            if(ratings[i]>ratings[i-1])
                candy[i] = candy[i-1] + 1;
        }
        for(int i=N-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                candy[i] = Math.max(candy[i] ,candy[i+1]+1);
        }
        int s = 0;
        for(int cd:candy)
            s+=cd;
        return s;
    }
}
