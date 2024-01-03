class Solution {
    public int numberOfBeams(String[] bank) {
        int result = 0;
        int prev = -1;
        for(String floor:bank){
            int device = 0;
            for(int i=0;i<floor.length();i++){
                if(floor.charAt(i)=='1')
                    device++;
            }
            if(device>0){
                if(prev==-1){
                    prev = device;
                }else{
                    result += prev*device;
                    prev = device;
                }
            }
        }
        return result;
    }
}
