package Hard;

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndex(mountainArr); 
        int leftHill = search(mountainArr,target,0,peak,true);
        if(leftHill != -1){
            return leftHill;
        }
        return search(mountainArr,target,peak+1,mountainArr.length()-1,false);
    }
    static int peakIndex(MountainArray arr){
        int start = 0;
        int end = arr.length()-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr.get(mid)>arr.get(mid+1)){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
    static int search(MountainArray arr,int target,int start,int end,boolean leftside){
        while(end>=start){
            int mid = start + (end-start)/2;
            if(target == arr.get(mid)){
                return mid;
            }
            if(leftside){
                if(target>arr.get(mid)){
                    start = mid+1;
                }
                else if(target<arr.get(mid)){
                    end = mid-1;
                }
            }
            else{
                if(target>arr.get(mid)){
                    end = mid-1;
                }
                else if(target<arr.get(mid)){
                    start = mid+1;
                }
            }
        }
        return -1; 
    }
}