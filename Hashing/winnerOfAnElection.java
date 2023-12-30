class Solution
{
    //TC - O(N) SC - O(N)
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // SC - O(N)
        Map<String,Integer> map = new HashMap<>();
        //TC - O(N)
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i],0);
            map.put(arr[i],map.get(arr[i])+1);
        }
        int votes = 0;
        String candidate = "";
        //TC - O(N)
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if(val>votes){
                votes = val;
                candidate = key;
            }else if(val==votes && key.compareTo(candidate)<0){
                candidate = key;
            }
        }
        return new String[]{candidate,Integer.toString(votes)};

    }
}

