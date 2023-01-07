class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(sum(gas)<sum(cost)){return -1;}
        int total = 0;
        int index = 0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            if(total<0){
                total=0;
                index = i+1;
            }
        }
        return index;
    }
    public int sum(int[] arr){
        int s = 0;
        for(int i=0;i<arr.length;i++){
            s+=arr[i];
        }
        return s;
    }
}
