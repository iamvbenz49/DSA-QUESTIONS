

class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i],0);
            map.put(arr[i],map.get(arr[i])+1);
        }
        int res = 0;
        for (Integer val : map.values())  {
            if(val>n/k)
                res++;
        }
        return res;
    }
}
